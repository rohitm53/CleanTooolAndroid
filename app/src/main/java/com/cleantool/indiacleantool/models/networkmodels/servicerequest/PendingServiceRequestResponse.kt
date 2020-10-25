package com.cleantool.indiacleantool.models.networkmodels.servicerequest

import com.cleantool.indiacleantool.models.networkmodels.common.Error

data class PendingServiceRequestResponse(
    val serviceRequests : List<ServiceRequest>,
    val error : Error
)