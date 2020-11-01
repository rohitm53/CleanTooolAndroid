package com.cleantool.indiacleantool.appmodules.bookingconfirmation

import android.content.Intent
import android.view.View
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.dashboard.DashboardActivity
import com.cleantool.indiacleantool.common.IntentKey
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceRequest
import com.cleantool.indiacleantool.utils.dateutils.CalendarUtils
import kotlinx.android.synthetic.main.activity_booking_confirmation.*
import kotlinx.android.synthetic.main.base_activity.*

class BookingConfirmationActivity : BaseActivity() {

    private lateinit var serviceRequest: ServiceRequest

    private var isFromHistory=false;

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_booking_confirmation,ll_body,true)

        serviceRequest = intent.extras?.get(IntentKey.ServiceRequest) as ServiceRequest
        isFromHistory = intent.getBooleanExtra(IntentKey.IsFromHistory,false)


        tv_service_id.text = serviceRequest.serviceReqCode
        tv_service_name.text=serviceRequest.serviceName
        tv_provider_name.text=serviceRequest.companyName
        tv_time_slot.text=CalendarUtils.getTimeInStandFormat(serviceRequest.scheduled)
        tv_estimate_time.text=CalendarUtils.getTimeInStandFormat(serviceRequest.scheduled)

        if(isFromHistory){

            tv_status_heading.visibility = View.VISIBLE
            tv_status.visibility = View.VISIBLE
            tv_status.text=serviceRequest.statusName

            tv_assignee_heading.visibility = View.GONE
            tv_assignee_name.visibility = View.GONE
            tv_assignee_mobile.visibility = View.GONE

            when(serviceRequest.statusCode) {
                ServiceRequest.StatusCode.PENDING -> {
                    tv_status.setTextColor(
                        ServiceIndiaApplication.getServiceIndiaApplication()
                            .getColor(R.color.pending_service_req)
                    )
                }

                ServiceRequest.StatusCode.ASSIGNED -> {
                    tv_status.setTextColor(
                        ServiceIndiaApplication.getServiceIndiaApplication()
                            .getColor(R.color.assigned_service_req)
                    )
                    tv_assignee_heading.visibility = View.VISIBLE
                    tv_assignee_name.visibility = View.VISIBLE
                    tv_assignee_mobile.visibility = View.VISIBLE
                    tv_assignee_name.text=serviceRequest.assignedEmployeeName
                    tv_assignee_mobile.text = "Mob : ${serviceRequest.assignedEmployeeMobile}"
                }

                ServiceRequest.StatusCode.INPROGRESS -> {
                    tv_status.setTextColor(
                        ServiceIndiaApplication.getServiceIndiaApplication()
                            .getColor(R.color.inprogress_service_req)
                    )
                }

                ServiceRequest.StatusCode.COMPLETED -> {
                    tv_status.setTextColor(
                        ServiceIndiaApplication.getServiceIndiaApplication()
                            .getColor(R.color.completed_service_req)
                    )
                }

                ServiceRequest.StatusCode.CANCELED -> {
                    tv_status.setTextColor(
                        ServiceIndiaApplication.getServiceIndiaApplication()
                            .getColor(R.color.cancelled_service_req)
                    )
                }
            }

        }else{
            tv_assignee_heading.visibility = View.GONE
            tv_assignee_name.visibility = View.GONE
            tv_assignee_mobile.visibility = View.GONE
            tv_status_heading.visibility = View.GONE
            tv_status.visibility = View.GONE
        }

        btn_back_to_home.setOnClickListener {
            if(isFromHistory){
                finish()
            }else{
                val intent = Intent(this,DashboardActivity::class.java).apply {
                    setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    putExtra(IntentKey.IsFromConfirmBooking,true)
                }
                startActivity(intent)
            }
        }

    }
}