package com.cleantool.indiacleantool.customdialog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.dashboard.settings.ServiceSelectorListner
import com.cleantool.indiacleantool.models.services.Service

class CustomServiceGridAdapter() : RecyclerView.Adapter<CustomServiceGridAdapter.CustomServiceGridViewHolder>() {

    private lateinit var context: Context
    private lateinit var listService:List<Service>
    private lateinit var serviceSelectorListner: ServiceSelectorListner

    constructor(context: Context, listService:List<Service>,serviceSelectorListner: ServiceSelectorListner)  : this(){
        this.context=context;
        this.listService=listService
        this.serviceSelectorListner=serviceSelectorListner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): CustomServiceGridViewHolder {
        val convertView = LayoutInflater.from(context).inflate(R.layout.adapter_dialog_service_cell,parent,false)
        return CustomServiceGridViewHolder(convertView)
    }

    override fun onBindViewHolder(viewHolder: CustomServiceGridViewHolder, position: Int) {
        val service = listService[position]
        viewHolder.tv_service_name_heading.text = service.serviceName
        viewHolder.iv_image.setImageResource(service.imageId)

        viewHolder.itemView.setOnClickListener {
            serviceSelectorListner.moveToProvidingCompanyList(service.serviceCode)
        }

    }
    override fun getItemCount(): Int {
        if(this::listService.isInitialized &&  listService.size>0){
            return listService.size
        }
        return 0
    }

    class CustomServiceGridViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tv_service_name_heading = itemView.findViewById<TextView>(R.id.tv_service_name_heading);
        val iv_image = itemView.findViewById<ImageView>(R.id.iv_image);
    }

    fun refresh(listService:List<Service>){
        this.listService=listService
        notifyDataSetChanged()
    }

}