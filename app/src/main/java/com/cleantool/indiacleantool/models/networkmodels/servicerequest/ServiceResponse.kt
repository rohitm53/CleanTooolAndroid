package com.cleantool.indiacleantool.models.networkmodels.servicerequest


import com.cleantool.indiacleantool.models.networkmodels.common.Error

data class ServiceResponse(
    val serviceReqCode: String,
    val statusCode: Int,
    val statusName: String,
    var scheduled: String,
    val error : Error
)