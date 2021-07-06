package com.cleantool.indiacleantool.appmodules.servicebooking

import android.content.Intent
import androidx.activity.viewModels
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.bookingconfirmation.BookingConfirmationActivity
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.common.IntentKey
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceRequest
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderCompany
import com.cleantool.indiacleantool.utils.dateutils.CalendarUtils
import kotlinx.android.synthetic.main.activity_book_service.*
import kotlinx.android.synthetic.main.base_activity.*
import java.io.Serializable

class BookServiceActivity : BaseActivity() {

    val viewModal: BookServiceViewModal by viewModels()

    private lateinit var serviceProviderCompany: ServiceProviderCompany
    private lateinit var serviceRequest: ServiceRequest

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_book_service,ll_body,true)

        serviceProviderCompany = intent.extras?.get(IntentKey.ServiceProvideDetails) as ServiceProviderCompany
        serviceRequest = intent.extras?.get(IntentKey.ServiceRequest) as ServiceRequest

        viewModal.serviceProviderCompany=serviceProviderCompany
        viewModal.serviceRequest=serviceRequest


        tv_service_name.text = serviceRequest.serviceName

        tv_provider_name.text = serviceProviderCompany.company.companyName
        tv_provider_address.text = serviceProviderCompany.company.address

        tv_time_slot.text = CalendarUtils.getTimeInStandFormat(serviceRequest.scheduled)

        viewModal.statusLiveData.observe(this,  {

            when(it.status) {

                BookServiceViewModal.SHOW_LOADER -> {
                    showLoader(it.data as String)
                }

                BookServiceViewModal.HIDE_LOADER -> {
                    hideLoader()
                }

                BookServiceViewModal.MOVE_TO_CONFIRMATION -> {
                    hideLoader()
                    moveToBookingConfirmation(it.data as ServiceRequest)
                }

                BookServiceViewModal.ERROR -> {
                    showToast("Error")
                }
            }
        })
        btn_book.setOnClickListener {
           viewModal.submitServiceRequest()
        }
    }

    private fun moveToBookingConfirmation(updatedRequest: ServiceRequest){
        val intent = Intent(this,BookingConfirmationActivity::class.java).apply {
            putExtra(IntentKey.ServiceRequest,updatedRequest as Serializable)
        }
        startActivity(intent)
    }
}