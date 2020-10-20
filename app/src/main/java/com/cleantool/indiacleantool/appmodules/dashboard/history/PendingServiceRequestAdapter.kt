package com.cleantool.indiacleantool.appmodules.dashboard.history

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.models.networkmodels.dashboardservicerequest.PendingServiceRequest
import com.cleantool.indiacleantool.utils.dateutils.CalendarUtils
import kotlinx.android.synthetic.main.adapter_pending_service_request_cell.view.*

class PendingServiceRequestAdapter(private var listPendingService: List<PendingServiceRequest>) : RecyclerView.Adapter<PendingServiceRequestAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_pending_service_request_cell,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val pendingServiceRequest = listPendingService[position]

        holder.tv_company_name.text = "By ${pendingServiceRequest.companyName}"
        holder.tv_req_id.text = "Req id : ${pendingServiceRequest.serviceReqCode}"
        holder.tv_service_name.text = pendingServiceRequest.serviceName
        holder.tv_time_slot.text = "Time  : ${CalendarUtils.getTimeInStandFormat(pendingServiceRequest.time)}"

    }

    override fun getItemCount() = listPendingService.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_service_name = itemView.tv_service_name
        val tv_company_name = itemView.tv_company_name
        val tv_time_slot = itemView.tv_time_slot
        val tv_req_id = itemView.tv_req_id
        val tv_status = itemView.tv_status
    }

}
