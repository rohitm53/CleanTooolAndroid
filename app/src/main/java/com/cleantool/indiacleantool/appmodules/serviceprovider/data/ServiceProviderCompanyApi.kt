package com.cleantool.indiacleantool.appmodules.serviceprovider.data

import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderDetailResponse
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Path

interface ServiceProviderCompanyApi {

    @GET("api/mobile/servicedetails/{service_code}")
    suspend fun getServiceProviderDetails(
        @HeaderMap headers : Map<String,String>,
        @Path("service_code") service_code:String) : ServiceProviderDetailResponse
}