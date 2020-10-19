package com.cleantool.indiacleantool.appmodules.servicebooking.data

import com.cleantool.indiacleantool.models.networkmodels.bookservice.ServiceRequest
import com.cleantool.indiacleantool.models.networkmodels.bookservice.ServiceResponse
import retrofit2.http.Body
import retrofit2.http.HeaderMap
import retrofit2.http.POST

interface BookServiceApi {

        @POST("api/servicerequest/book")
        suspend fun bookService(
            @HeaderMap headers : Map<String,String>,
            @Body serviceRequest: ServiceRequest
        ) : ServiceResponse

}