package com.cleantool.indiacleantool.appmodules.bookingconfirmation

import android.content.Intent
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.dashboard.DashboardActivity
import com.cleantool.indiacleantool.common.IntentKey
import com.cleantool.indiacleantool.models.networkmodels.bookservice.ServiceRequest
import com.cleantool.indiacleantool.utils.dateutils.CalendarUtils
import kotlinx.android.synthetic.main.activity_booking_confirmation.*
import kotlinx.android.synthetic.main.base_activity.*

class BookingConfirmationActivity : BaseActivity() {

    private lateinit var serviceRequest: ServiceRequest
    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_booking_confirmation,ll_body,true)

        serviceRequest = intent.extras?.get(IntentKey.ServiceRequest) as ServiceRequest


        tv_service_id.text = serviceRequest.serviceReqCode
        tv_service_name.text=serviceRequest.serviceName
        tv_provider_name.text=serviceRequest.companyName
        tv_time_slot.text=CalendarUtils.getTimeInStandFormat(serviceRequest.time)
        tv_estimate_time.text=CalendarUtils.getTimeInStandFormat(serviceRequest.time)

        btn_back_to_home.setOnClickListener {
            val intent = Intent(this,DashboardActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

    }
}