package com.cleantool.indiacleantool.appmodules.dashboard.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.dashboard.CleanTypeSelectorListner
import com.cleantool.indiacleantool.models.servicetypes.ServiceType


class HomeServiceGridAdapter() : RecyclerView.Adapter<HomeServiceGridAdapter.HomerServiceViewHolder>() {

    lateinit var context: Context
    lateinit var listServices: List<ServiceType>
    private lateinit var cleanTypeSelectorListner: CleanTypeSelectorListner

    constructor(context: Context, listServices:List<ServiceType>, cleanTypeSelectorListner: CleanTypeSelectorListner) : this() {
        this.context=context
        this.listServices=listServices
        this.cleanTypeSelectorListner=cleanTypeSelectorListner
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomerServiceViewHolder {
        val convertView = LayoutInflater.from(context).inflate(R.layout.adapter_services_cell,parent,false)
        return HomerServiceViewHolder(convertView)
    }

    override fun getItemCount(): Int {
        if(listServices.size>0){
            return listServices.size
        }else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: HomerServiceViewHolder, position: Int) {
        holder.tv_service_name.text=listServices[position].name
        holder.iv_image.setImageResource(listServices[position].imageId)

        holder.itemView.setOnClickListener{
            cleanTypeSelectorListner.openServicePopup(holder.itemView,listServices[position].code)
        }

    }

    inner class HomerServiceViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView){
        val iv_image = itemView.findViewById<ImageView>(R.id.iv_image)
        val tv_service_name = itemView.findViewById<TextView>(R.id.tv_service_name_heading)
    }

    fun refresh(listServices:List<ServiceType>){
        this.listServices=listServices
    }

}