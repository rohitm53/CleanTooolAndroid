package com.cleantool.indiacleantool.appmodules.dashboard.history

import com.cleantool.indiacleantool.common.ServiceUrls
import com.cleantool.indiacleantool.models.networkmodels.dashboardservicerequest.PendingServiceResponse
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface DashboardHistoryApi {

    @GET(ServiceUrls.GetAllMobileUserServiceRequest)
    suspend fun getAllMobileUserServiceRequest(@HeaderMap header : Map<String,String>) : PendingServiceResponse

}