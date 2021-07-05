package com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidercompanylist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.serviceprovider.listner.ServiceProviderListner
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderCompanyDetail

class ServiceProviderCompanyAdapter(
    private val listServiceProvider : List<ServiceProviderCompanyDetail>,
    private val serviceProviderListner: ServiceProviderListner
) : RecyclerView.Adapter<ServiceProviderCompanyAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_service_provider_company_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val serviceProviderCompanyDetail = listServiceProvider[position]
        val company = serviceProviderCompanyDetail.company
//        holder.tv_sno.text = (position+1).toString()
        holder.tv_company_name.text = company.companyName
        holder.tv_company_address.text = company.address

        holder.itemView.setOnClickListener {
            serviceProviderListner.moveToServiceDetails(serviceProviderCompanyDetail)

        }

    }

    override fun getItemCount() = listServiceProvider.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
//        val tv_sno = itemView.findViewById<TextView>(R.id.tv_sno)
        val tv_company_name = itemView.findViewById<TextView>(R.id.tv_company_name)
        val tv_company_address = itemView.findViewById<TextView>(R.id.tv_company_address)
    }
}