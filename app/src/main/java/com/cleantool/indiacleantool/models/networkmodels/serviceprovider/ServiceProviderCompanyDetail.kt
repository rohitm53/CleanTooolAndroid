package com.cleantool.indiacleantool.models.networkmodels.serviceprovider


import com.google.gson.annotations.SerializedName

data class ServiceProviderCompanyDetail(
    val availableEmployeeCount: Int,
    val company: Company,
    val timeSlots: List<TimeSlot>
)