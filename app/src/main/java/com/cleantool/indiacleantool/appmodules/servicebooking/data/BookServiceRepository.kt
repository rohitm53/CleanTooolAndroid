package com.cleantool.indiacleantool.appmodules.servicebooking.data

import com.cleantool.indiacleantool.common.Preference
import com.cleantool.indiacleantool.database.AppDatabase
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceRequest
import com.cleantool.indiacleantool.models.networkmodels.servicerequest.ServiceResponse
import com.cleantool.indiacleantool.models.networkmodels.common.NetworkResultWrapper
import com.cleantool.indiacleantool.networkcalls.safeApiCall

class BookServiceRepository(
    var bookServiceApi: BookServiceApi,
    var appDatabase: AppDatabase,
    var preference: Preference) {


    suspend fun booksService(serviceRequest: ServiceRequest) : NetworkResultWrapper<ServiceResponse> {

        val headerMap = HashMap<String,String>()
        headerMap.put("Authorization",preference.getStringValue(Preference.Keys.JsonWebToken))
        return safeApiCall { bookServiceApi.bookService(headerMap,serviceRequest) }

    }

}