package com.cleantool.indiacleantool.appmodules.dashboard.history

import com.cleantool.indiacleantool.common.Preference
import com.cleantool.indiacleantool.models.networkmodels.commosn.NetworkResultWrapper
import com.cleantool.indiacleantool.models.networkmodels.dashboardservicerequest.PendingServiceResponse
import com.cleantool.indiacleantool.networkcalls.safeApiCall

class DashboardHistoryRepository(
    var dashboardHistoryApi: DashboardHistoryApi,
    var preference: Preference
){

    suspend fun getAllServiceRequest() : NetworkResultWrapper<PendingServiceResponse>{

        val headerMap = HashMap<String,String>()
        headerMap.put("Authorization",preference.getStringValue(Preference.Keys.JsonWebToken))
        return safeApiCall { dashboardHistoryApi.getAllMobileUserServiceRequest(headerMap) }
    }


}