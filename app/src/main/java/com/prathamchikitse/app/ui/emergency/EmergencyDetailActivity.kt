package com.prathamchikitse.app.ui.emergency

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.prathamchikitse.app.R
import com.prathamchikitse.app.data.Emergency
import com.prathamchikitse.app.data.EmergencyRepository
import com.prathamchikitse.app.databinding.ActivityEmergencyDetailBinding
import com.prathamchikitse.app.databinding.ItemEmergencyStepBinding
import com.prathamchikitse.app.utils.LanguageManager
import com.prathamchikitse.app.utils.TTSManager

class EmergencyDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_EMERGENCY_ID = "extra_emergency_id"
    }

    private lateinit var binding: ActivityEmergencyDetailBinding
    private lateinit var ttsManager: TTSManager
    private var currentEmergency: Emergency? = null
    private var isAudioPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmergencyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emergencyId = intent.getIntExtra(EXTRA_EMERGENCY_ID, -1)
        currentEmergency = EmergencyRepository.getEmergencies().find { it.id == emergencyId }

        if (currentEmergency == null) {
            finish()
            return
        }

        setupUI()
        setupTTS()
    }

    private fun setupUI() {
        binding.toolbar.setNavigationOnClickListener { finish() }
        
        binding.btnLanguageToggle.setOnClickListener {
            val isKn = LanguageManager.isKannada(this)
            LanguageManager.setKannada(this, !isKn)
            updateLanguageUI()
            binding.viewPager.adapter?.notifyDataSetChanged()
        }

        updateLanguageUI()

        binding.viewPager.adapter = EmergencyStepAdapter(currentEmergency!!)
        
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateNavigationButtons(position)
            }
        })

        binding.btnNextStep.setOnClickListener {
            val currentItem = binding.viewPager.currentItem
            if (currentItem < (binding.viewPager.adapter?.itemCount ?: 0) - 1) {
                binding.viewPager.currentItem = currentItem + 1
            }
        }

        binding.btnPrevStep.setOnClickListener {
            val currentItem = binding.viewPager.currentItem
            if (currentItem > 0) {
                binding.viewPager.currentItem = currentItem - 1
            }
        }
        
        binding.fabAudio.setOnClickListener {
            toggleAudio()
        }
    }

    private fun updateLanguageUI() {
        val isKn = LanguageManager.isKannada(this)
        binding.btnLanguageToggle.text = if (isKn) getString(R.string.btn_lang_en) else getString(R.string.btn_lang_kn)
        binding.toolbar.title = if (isKn) currentEmergency?.titleKn else currentEmergency?.titleEn
    }

    private fun updateNavigationButtons(position: Int) {
        val totalItems = binding.viewPager.adapter?.itemCount ?: 0
        binding.btnPrevStep.isEnabled = position > 0
        binding.btnNextStep.isEnabled = position < totalItems - 1
        
        if (isAudioPlaying) {
            playCurrentStepAudio(position)
        }
    }

    private fun setupTTS() {
        ttsManager = TTSManager(this)
    }

    private fun toggleAudio() {
        isAudioPlaying = !isAudioPlaying
        if (isAudioPlaying) {
            binding.fabAudio.text = getString(R.string.action_audio_stop)
            playCurrentStepAudio(binding.viewPager.currentItem)
        } else {
            binding.fabAudio.text = getString(R.string.action_audio_play)
            ttsManager.stop()
        }
    }

    private fun playCurrentStepAudio(position: Int) {
        val emergency = currentEmergency ?: return
        val isKn = LanguageManager.isKannada(this)
        
        if (position < emergency.steps.size) {
            val step = emergency.steps[position]
            val textToSpeak = if (isKn) step.instructionKn else step.instructionEn
            ttsManager.speak(textToSpeak, isKn)
        } else {
            val dosTitle = if (isKn) "ಮಾಡಬೇಕಾದವು" else "Do's"
            val dontsTitle = if (isKn) "ಮಾಡಬಾರದವು" else "Don'ts"
            
            val dosList = if (isKn) emergency.dosKn else emergency.dosEn
            val dontsList = if (isKn) emergency.dontsKn else emergency.dontsEn
            
            var textToSpeak = ""
            if (dosList.isNotEmpty()) {
                textToSpeak += "$dosTitle. " + dosList.joinToString(". ") + ". "
            }
            if (dontsList.isNotEmpty()) {
                textToSpeak += "$dontsTitle. " + dontsList.joinToString(". ") + "."
            }
            
            if (textToSpeak.isNotEmpty()) {
                ttsManager.speak(textToSpeak, isKn)
            }
        }
    }

    override fun onDestroy() {
        ttsManager.shutdown()
        super.onDestroy()
    }
}

class EmergencyStepAdapter(private val emergency: Emergency) : RecyclerView.Adapter<EmergencyStepAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemEmergencyStepBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEmergencyStepBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val isKn = LanguageManager.isKannada(context)
        
        if (position < emergency.steps.size) {
            val step = emergency.steps[position]
            holder.binding.tvStepNumber.text = step.stepNumber.toString()
            holder.binding.tvInstruction.text = if (isKn) step.instructionKn else step.instructionEn
            
            // Hide Do's/Don'ts for normal steps
            holder.binding.llDosAndDonts.visibility = View.GONE
        } else {
            // Last page for Do's and Don'ts if available
            holder.binding.tvStepNumber.text = "!"
            holder.binding.tvInstruction.text = if (isKn) "ನೆನಪಿಡಬೇಕಾದ ಅಂಶಗಳು" else "Important Points"
            holder.binding.ivIllustration.visibility = View.GONE
            
            holder.binding.llDosAndDonts.visibility = View.VISIBLE
            
            val dos = if (isKn) emergency.dosKn else emergency.dosEn
            val donts = if (isKn) emergency.dontsKn else emergency.dontsEn
            
            if (dos.isNotEmpty()) {
                holder.binding.tvDosTitle.visibility = View.VISIBLE
                holder.binding.tvDosTitle.text = if (isKn) "ಮಾಡಬೇಕಾದವು" else "Do's"
                holder.binding.tvDosContent.visibility = View.VISIBLE
                holder.binding.tvDosContent.text = dos.joinToString("\n") { "• $it" }
            }
            
            if (donts.isNotEmpty()) {
                holder.binding.tvDontsTitle.visibility = View.VISIBLE
                holder.binding.tvDontsTitle.text = if (isKn) "ಮಾಡಬಾರದವು" else "Don'ts"
                holder.binding.tvDontsContent.visibility = View.VISIBLE
                holder.binding.tvDontsContent.text = donts.joinToString("\n") { "• $it" }
            }
        }
    }

    override fun getItemCount(): Int {
        val hasDosOrDonts = emergency.dosEn.isNotEmpty() || emergency.dontsEn.isNotEmpty()
        return emergency.steps.size + if (hasDosOrDonts) 1 else 0
    }
}
