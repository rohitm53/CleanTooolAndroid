package com.cleantool.indiacleantool.appmodules.servicebooking

import android.content.Intent
import androidx.activity.viewModels
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.bookingconfirmation.BookingConfirmationActivity
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.common.IntentKey
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceRequest
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderCompanyDetail
import com.cleantool.indiacleantool.utils.dateutils.CalendarUtils
import kotlinx.android.synthetic.main.activity_book_service.*
import kotlinx.android.synthetic.main.base_activity.*
import java.io.Serializable

class BookServiceActivity : BaseActivity() {

    val viewModal: BookServiceViewModal by viewModels()

    private lateinit var serviceProviderCompanyDetail: ServiceProviderCompanyDetail
    private lateinit var serviceRequest: ServiceRequest

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_book_service,ll_body,true)

        serviceProviderCompanyDetail = intent.extras?.get(IntentKey.ServiceProvideDetails) as ServiceProviderCompanyDetail
        serviceRequest = intent.extras?.get(IntentKey.ServiceRequest) as ServiceRequest

        viewModal.serviceProviderCompanyDetail=serviceProviderCompanyDetail
        viewModal.serviceRequest=serviceRequest


        tv_service_name.text = serviceRequest.serviceName

        tv_provider_name.text = serviceProviderCompanyDetail.company.companyName
        tv_provider_address.text = serviceProviderCompanyDetail.company.address

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