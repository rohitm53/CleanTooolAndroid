package com.cleantool.indiacleantool.appmodules.servicebooking.data

import com.cleantool.indiacleantool.common.ServiceUrls
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceRequest
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceResponse
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface BookServiceApi {

    @POST(ServiceUrls.BookServiceUrl)
    suspend fun bookService(
        @HeaderMap headers : Map<String,String>,
        @Body serviceRequest: ServiceRequest
    ) : ServiceResponse

}