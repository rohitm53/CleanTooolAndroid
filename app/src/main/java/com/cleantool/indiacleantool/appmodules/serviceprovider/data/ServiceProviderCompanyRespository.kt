package com.cleantool.indiacleantool.appmodules.serviceprovider.data

import com.cleantool.indiacleantool.common.Preference
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.common.NetworkResultWrapper
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderDetailResponse
import com.cleantool.indiacleantool.networkcalls.safeApiCall
import com.cleantool.indiacleantool.utils.dateutils.CalendarUtils
import javax.inject.Inject

class ServiceProviderCompanyRespository() {

    init {

        ServiceIndiaApplication.getApplicationComponent().inject(this)
    }

    @Inject
    lateinit var serviceProviderCompanyApi: ServiceProviderCompanyApi

    @Inject
    lateinit var preference: Preference


    suspend fun getServiceProviderCompanyDetails(service_code:String)
            : NetworkResultWrapper<ServiceProviderDetailResponse> {

        val headerMap = HashMap<String,String>()
        headerMap["Authorization"] = preference.getStringValue(Preference.Keys.JsonWebToken)

        return safeApiCall {
            serviceProviderCompanyApi.getServiceProviderDetails(headerMap,
                service_code,
                CalendarUtils.getCurrentDateInStandFormat()
            )
        }
    }

}