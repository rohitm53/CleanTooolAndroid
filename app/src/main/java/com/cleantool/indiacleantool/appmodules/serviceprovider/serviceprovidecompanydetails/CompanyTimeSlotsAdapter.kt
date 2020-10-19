package com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidecompanydetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.serviceprovider.listner.CompanyDetailsListner
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.TimeSlot
import com.cleantool.indiacleantool.utils.dateutils.CalendarUtils

class CompanyTimeSlotsAdapter(
    private var listTimeSlots : List<TimeSlot>,
    private var companyDetailsListner: CompanyDetailsListner
) : RecyclerView.Adapter<CompanyTimeSlotsAdapter.ViewHolder>() {

    private var selectedPosition:Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_time_slots,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val timeSlot = listTimeSlots[position]
        holder.radio_time_slot.text = CalendarUtils.getTimeInStandFormat(timeSlot.time)
        holder.radio_time_slot.isChecked=(selectedPosition==position)


        holder.radio_time_slot.setOnClickListener {
            selectedPosition=position
            companyDetailsListner.onTimeSlotsSelected(timeSlot)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = listTimeSlots.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val radio_time_slot = itemView.findViewById<RadioButton>(R.id.radio_time_slot)

    }

}