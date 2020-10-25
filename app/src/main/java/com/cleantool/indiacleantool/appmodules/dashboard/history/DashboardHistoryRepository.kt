package com.cleantool.indiacleantool.appmodules.dashboard.history

import com.cleantool.indiacleantool.appmodules.dashboard.data.DashboardApi
import com.cleantool.indiacleantool.common.Preference
import com.cleantool.indiacleantool.models.networkmodels.commosn.NetworkResultWrapper
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.PendingServiceRequestResponse
import com.cleantool.indiacleantool.networkcalls.safeApiCall

class DashboardHistoryRepository(
    var dashboardApi: DashboardApi,
    var preference: Preference
){

    suspend fun getAllServiceRequest() : NetworkResultWrapper<PendingServiceRequestResponse>{

        val headerMap = HashMap<String,String>()
        headerMap.put("Authorization",preference.getStringValue(Preference.Keys.JsonWebToken))
        return safeApiCall { dashboardApi.getAllMobileUserServiceRequest(headerMap) }
    }


}