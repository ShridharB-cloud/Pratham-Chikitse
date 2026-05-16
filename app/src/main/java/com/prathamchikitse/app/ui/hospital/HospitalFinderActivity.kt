package com.prathamchikitse.app.ui.hospital

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prathamchikitse.app.data.EmergencyRepository
import com.prathamchikitse.app.data.Hospital
import android.content.Intent
import android.net.Uri

import com.prathamchikitse.app.databinding.ActivityHospitalFinderBinding
import com.prathamchikitse.app.databinding.ItemHospitalBinding

class HospitalFinderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalFinderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalFinderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { finish() }

        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val hospitals = EmergencyRepository.getHospitals().sortedBy { it.distanceKm }
        binding.rvHospitals.layoutManager = LinearLayoutManager(this)
        binding.rvHospitals.adapter = HospitalAdapter(hospitals)
    }
}

class HospitalAdapter(private val hospitals: List<Hospital>) : RecyclerView.Adapter<HospitalAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemHospitalBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hospital = hospitals[position]
        holder.binding.tvHospitalName.text = hospital.name
        holder.binding.tvDistance.text = "${hospital.distanceKm} km"
        holder.binding.tvAddress.text = hospital.address
        holder.binding.tvPhone.text = hospital.phone
        
        holder.binding.btnCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${hospital.phone}")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = hospitals.size
}
