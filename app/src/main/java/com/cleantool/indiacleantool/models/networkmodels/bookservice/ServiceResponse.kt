package com.cleantool.indiacleantool.models.networkmodels.bookservice


import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.Error
import com.google.gson.annotations.SerializedName

data class ServiceResponse(
    val serviceReqCode: String,
    val statusCode: Int,
    val statusName: String,
    var time: String,
    val error : Error
)