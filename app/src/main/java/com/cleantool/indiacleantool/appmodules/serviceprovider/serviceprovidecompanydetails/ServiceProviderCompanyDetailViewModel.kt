package com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidecompanydetails

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleantool.indiacleantool.common.Constants
import com.cleantool.indiacleantool.common.Preference
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.common.StaticDataProvider
import com.cleantool.indiacleantool.database.AppDatabase
import com.cleantool.indiacleantool.models.networkmodels.bookservice.ServiceRequest
import com.cleantool.indiacleantool.models.networkmodels.commosn.NetworkResultWrapper
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.Company
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.TimeSlot
import com.cleantool.indiacleantool.models.services.Service
import com.cleantool.indiacleantool.utils.dateutils.CalendarUtils
import com.cleantool.indiacleantool.utils.stringutils.getUniqueStringId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ServiceProviderCompanyDetailViewModel : ViewModel(){


    var hmServices : HashMap<String,List<Service>>

    init {
        ServiceIndiaApplication.getApplicationComponent().inject(this)
        hmServices = HashMap()
        hmServices.put(Constants.House_Hold_Type, StaticDataProvider.getServiceDataByType(Constants.House_Hold_Type))
        hmServices.put(Constants.Commercial_Type, StaticDataProvider.getServiceDataByType(Constants.Commercial_Type))
        hmServices.put(Constants.Laundary_Type, StaticDataProvider.getServiceDataByType(Constants.Laundary_Type))
    }


    @Inject lateinit var preference: Preference

    var serviceRequest =ServiceRequest()
    lateinit var timeSlot: TimeSlot
    lateinit var company : Company
    var serviceType = ""
    var serviceCode = ""
    var serviceName = ""

    fun assigneServiceName(){
        serviceName = hmServices.get(serviceType)?.find { service ->
            service.serviceCode==serviceCode
        }!!.serviceName
    }

    fun isTimeSlotSelected():Boolean = (this::timeSlot.isInitialized)



    fun generateServiceRequest() : ServiceRequest{
         return serviceRequest.apply {
           serviceCode=this@ServiceProviderCompanyDetailViewModel.serviceCode
           companyCode=company.companyCode
           timeSlotCode=timeSlot.slotCode
           mobileUserCode = preference.getStringValue(Preference.Keys.UserCode)
           serviceMsgId = getUniqueStringId()

           serviceName = this@ServiceProviderCompanyDetailViewModel.serviceName
           time=  CalendarUtils.getTimeInStandFormat(timeSlot.time)
        }
    }

}