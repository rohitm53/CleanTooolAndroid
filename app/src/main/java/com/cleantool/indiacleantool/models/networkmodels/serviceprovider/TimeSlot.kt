package com.cleantool.indiacleantool.models.networkmodels.serviceprovider


import com.google.gson.annotations.SerializedName

data class TimeSlot(
    val id: Int,
    val slotCode: String,
    val time: String
)