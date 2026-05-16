package com.prathamchikitse.app.ui.home

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prathamchikitse.app.R
import com.prathamchikitse.app.data.Emergency
import com.prathamchikitse.app.data.EmergencyRepository
import com.prathamchikitse.app.databinding.ActivityHomeBinding
import com.prathamchikitse.app.databinding.ItemEmergencyTileBinding
import com.prathamchikitse.app.ui.emergency.EmergencyDetailActivity
import com.prathamchikitse.app.ui.hospital.HospitalFinderActivity
import com.prathamchikitse.app.utils.LanguageManager

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: EmergencyAdapter
    private var allEmergencies: List<Emergency> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()
        setupRecyclerView()
        updateLanguageUI()
    }

    private fun setupViews() {
        binding.btnLanguageToggle.setOnClickListener {
            val isKn = LanguageManager.isKannada(this)
            LanguageManager.setKannada(this, !isKn)
            updateLanguageUI()
            adapter.notifyDataSetChanged()
        }

        binding.btnInfo.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("About")
                .setMessage("Prathama Chikitsa is a First-Aid Guide developed as an Internship Project.\n\nVersion 1.0")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        binding.btnHospitalFinder.setOnClickListener {
            startActivity(Intent(this, HospitalFinderActivity::class.java))
        }

        binding.fabCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:108")
            startActivity(intent)
        }

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                filterEmergencies(s.toString())
            }
        })
    }
    
    private fun filterEmergencies(query: String) {
        val isKn = LanguageManager.isKannada(this)
        val filtered = if (query.isBlank()) {
            allEmergencies
        } else {
            allEmergencies.filter {
                if (isKn) {
                    it.titleKn.contains(query, ignoreCase = true)
                } else {
                    it.titleEn.contains(query, ignoreCase = true)
                }
            }
        }
        adapter.updateData(filtered)
    }

    private fun updateLanguageUI() {
        val isKn = LanguageManager.isKannada(this)
        binding.btnLanguageToggle.text = if (isKn) getString(R.string.btn_lang_en) else getString(R.string.btn_lang_kn)
    }

    private fun setupRecyclerView() {
        allEmergencies = EmergencyRepository.getEmergencies()
        adapter = EmergencyAdapter(allEmergencies) { emergency ->
            val intent = Intent(this, EmergencyDetailActivity::class.java).apply {
                putExtra(EmergencyDetailActivity.EXTRA_EMERGENCY_ID, emergency.id)
            }
            startActivity(intent)
        }
        binding.rvEmergencies.layoutManager = GridLayoutManager(this, 2)
        binding.rvEmergencies.adapter = adapter
        
        // Add layout animation
        val context = binding.rvEmergencies.context
        val controller = android.view.animation.AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
        binding.rvEmergencies.layoutAnimation = controller
    }
}

class EmergencyAdapter(
    private var emergencies: List<Emergency>,
    private val onItemClick: (Emergency) -> Unit
) : RecyclerView.Adapter<EmergencyAdapter.ViewHolder>() {

    fun updateData(newEmergencies: List<Emergency>) {
        emergencies = newEmergencies
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemEmergencyTileBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEmergencyTileBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val emergency = emergencies[position]
        val context = holder.itemView.context
        val isKannada = LanguageManager.isKannada(context)

        holder.binding.tvTitle.text = if (isKannada) emergency.titleKn else emergency.titleEn
        
        // Set the icon based on the resource name
        val resourceId = context.resources.getIdentifier(emergency.iconResName, "drawable", context.packageName)
        if (resourceId != 0) {
            holder.binding.ivIcon.setImageResource(resourceId)
        } else {
            holder.binding.ivIcon.setImageResource(R.drawable.ic_launcher_foreground)
        }
        
        try {
            val color = android.graphics.Color.parseColor(emergency.colorHex)
            holder.binding.cvIconBackground.setCardBackgroundColor(color)
            holder.binding.tvTitle.setTextColor(color) // Also tint the text to match!
        } catch (e: Exception) {
            // Fallback
        }

        holder.itemView.setOnClickListener { onItemClick(emergency) }
    }

    override fun getItemCount() = emergencies.size
}
