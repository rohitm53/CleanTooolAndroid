package com.cleantool.indiacleantool.appmodules.providercompany

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.models.providingcompany.TimeSlots
import java.time.format.DateTimeFormatter

class ProviderCompanyListAdapter() : RecyclerView.Adapter<ProviderCompanyListAdapter.ProviderCompanyListViewHolder>() {

    private lateinit var context: Context
    private lateinit var companyTimeSlots:List<TimeSlots>

    constructor(context: Context,companyTimeSlots:List<TimeSlots>) :this(){
        this.context=context
        this.companyTimeSlots=companyTimeSlots
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProviderCompanyListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_provider_company_cell,parent,false)
        return ProviderCompanyListViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(companyTimeSlots.size>0){
            return companyTimeSlots.size
        }else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: ProviderCompanyListViewHolder, position: Int) {

        val timeSlot = companyTimeSlots[position]

        holder.tv_sno.text=(position+1).toString()
        holder.tv_starttime.text=timeSlot.startTime?.format(DateTimeFormatter.ofPattern("HH:mm"))
        holder.tv_endTime.text=timeSlot.endTime?.format(DateTimeFormatter.ofPattern("HH:mm"))
        holder.tv_availablePersons.text=timeSlot.availablePersons.toString()

        if(timeSlot.isSelected){
            holder.tv_enterReqPerson.visibility=View.VISIBLE
            holder.ed_req_person.visibility=View.VISIBLE
        }else{
            holder.tv_enterReqPerson.visibility=View.GONE
            holder.ed_req_person.visibility=View.GONE
        }

        holder.itemView.setOnClickListener {
            timeSlot.isSelected=true
            holder.tv_enterReqPerson.visibility=View.VISIBLE
            holder.ed_req_person.visibility=View.VISIBLE
            toggleSelectItem(position)

        }
    }

    private fun toggleSelectItem(position: Int){

        for(i in 0 until companyTimeSlots.size){
            if(i!=position){
                companyTimeSlots[i].isSelected=false
            }
        }
        notifyDataSetChanged()

    }

    fun refresh(companyTimeSlots:List<TimeSlots>){
        this.companyTimeSlots=companyTimeSlots
        notifyDataSetChanged()
    }

    inner class ProviderCompanyListViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val tv_sno = itemview.findViewById<TextView>(R.id.tv_sno)
        val tv_starttime = itemview.findViewById<TextView>(R.id.tv_starttime)
        val tv_endTime = itemview.findViewById<TextView>(R.id.tv_endTime)
        val tv_availablePersons = itemview.findViewById<TextView>(R.id.tv_availablePersons)
        val tv_enterReqPerson = itemview.findViewById<TextView>(R.id.tv_enterReqPerson)
        val ed_req_person = itemview.findViewById<EditText>(R.id.ed_req_person)

    }



}