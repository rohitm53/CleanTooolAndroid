package com.cleantool.indiacleantool.appmodules.dashboard.data

import com.cleantool.indiacleantool.common.ServiceUrls
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.PendingServiceRequestResponse
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path

interface DashboardApi {

    @GET(ServiceUrls.GetAllMobileUserServiceRequest)
    suspend fun getAllMobileUserServiceRequest(@HeaderMap header : Map<String,String>) : PendingServiceRequestResponse

}