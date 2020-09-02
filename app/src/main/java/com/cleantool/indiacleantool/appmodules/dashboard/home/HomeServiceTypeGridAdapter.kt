package com.cleantool.indiacleantool.appmodules.dashboard.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.dashboard.ServiceTypeSelectorListner
import com.cleantool.indiacleantool.models.servicetypes.ServiceType


class HomeServiceTypeGridAdapter() : RecyclerView.Adapter<HomeServiceTypeGridAdapter.HomerServiceTypeViewHolder>() {

    lateinit var context: Context
    lateinit var listServicesTypes: List<ServiceType>
    private lateinit var serviceTypeSelectorListner: ServiceTypeSelectorListner

    constructor(context: Context, listServicesTypes:List<ServiceType>, serviceTypeSelectorListner: ServiceTypeSelectorListner) : this() {
        this.context=context
        this.listServicesTypes=listServicesTypes
        this.serviceTypeSelectorListner=serviceTypeSelectorListner
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomerServiceTypeViewHolder {
        val convertView = LayoutInflater.from(context).inflate(R.layout.adapter_services_type_cell,parent,false)
        return HomerServiceTypeViewHolder(convertView)
    }

    override fun getItemCount(): Int {
        if(listServicesTypes.size>0){
            return listServicesTypes.size
        }else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: HomerServiceTypeViewHolder, position: Int) {
        holder.tv_service_type_name_heading.text=listServicesTypes[position].name
        holder.iv_image.setImageResource(listServicesTypes[position].imageId)

        holder.itemView.setOnClickListener{
            serviceTypeSelectorListner.openServicePopup(listServicesTypes[position].code)
        }

    }

    class HomerServiceTypeViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView){
        val iv_image = itemView.findViewById<ImageView>(R.id.iv_image)
        val tv_service_type_name_heading = itemView.findViewById<TextView>(R.id.tv_service_type_name_heading)
    }

    fun refresh(listServices:List<ServiceType>){
        this.listServicesTypes=listServices
    }

}