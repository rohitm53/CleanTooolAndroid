package com.cleantool.indiacleantool.appmodules.serviceprovider.data

import com.cleantool.indiacleantool.common.ServiceUrls
import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderDetailResponse
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceProviderCompanyApi {

    @GET(ServiceUrls.ServiceProviderUrl)
    suspend fun getServiceProviderDetails(
        @HeaderMap headers : Map<String,String>,
        @Query("service_code") serviceCode : String,
        @Query("date") date : String?
    ) : ServiceProviderDetailResponse
}