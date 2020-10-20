package com.cleantool.indiacleantool.models.networkmodels.dashboardservicerequest


import com.google.gson.annotations.SerializedName

data class PendingServiceRequest(
    val companyCode: String,
    val companyName: String,
    val employeeMobile: Any,
    val employeeName: Any,
    val mobileUserCode: String,
    val serviceCode: String,
    val serviceName: String,
    val serviceReqCode: String,
    val statusCode: Int,
    val statusName: String,
    val time: String,
    val timeSlotCode: String
)