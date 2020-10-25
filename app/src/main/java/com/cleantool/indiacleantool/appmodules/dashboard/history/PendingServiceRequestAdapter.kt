package com.cleantool.indiacleantool.appmodules.dashboard.history

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.bookingconfirmation.BookingConfirmationActivity
import com.cleantool.indiacleantool.common.IntentKey
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceRequest
import com.cleantool.indiacleantool.utils.dateutils.CalendarUtils
import kotlinx.android.synthetic.main.adapter_pending_service_request_cell.view.*

class PendingServiceRequestAdapter(
    private val context:Context,
    private var listPendingService: List<ServiceRequest>
) : RecyclerView.Adapter<PendingServiceRequestAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_pending_service_request_cell,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val serviceRequest = listPendingService[position]

        holder.tv_company_name.text = "By ${serviceRequest.companyName}"
        holder.tv_req_id.text = "Req id : ${serviceRequest.serviceReqCode}"
        holder.tv_service_name.text = serviceRequest.serviceName
        holder.tv_time_slot.text = "Time  : ${CalendarUtils.getTimeInStandFormat(serviceRequest.time)}"
        holder.tv_status.text=serviceRequest.statusName


        when(serviceRequest.statusCode){
            ServiceRequest.StatusCode.PENDING-> {
                holder.tv_status.setTextColor(ServiceIndiaApplication.getServiceIndiaApplication().getColor(R.color.pending_service_req))
            }

            ServiceRequest.StatusCode.ASSIGNED-> {
                holder.tv_status.setTextColor(ServiceIndiaApplication.getServiceIndiaApplication().getColor(R.color.assigned_service_req))
            }

            ServiceRequest.StatusCode.INPROGRESS -> {
                holder.tv_status.setTextColor(ServiceIndiaApplication.getServiceIndiaApplication().getColor(R.color.inprogress_service_req))
            }

            ServiceRequest.StatusCode.COMPLETED -> {
                holder.tv_status.setTextColor(ServiceIndiaApplication.getServiceIndiaApplication().getColor(R.color.completed_service_req))
            }

            ServiceRequest.StatusCode.CANCELED -> {
                holder.tv_status.setTextColor(ServiceIndiaApplication.getServiceIndiaApplication().getColor(R.color.cancelled_service_req))
            }
        }


        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,BookingConfirmationActivity::class.java).apply {
                putExtra(IntentKey.IsFromHistory,true)
                putExtra(IntentKey.ServiceRequest,serviceRequest)
            }
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(context as AppCompatActivity,holder.tv_service_name,"servicenametoanimate")
            holder.itemView.context.startActivity(intent,options.toBundle())
        }
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
