package com.cleantool.indiacleantool.models.networkmodels.serviceprovider


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ServiceProviderCompany  (
    val availableEmployeeCount: Int,
    val company: Company,
    val timeSlots: List<TimeSlot>
):Serializable