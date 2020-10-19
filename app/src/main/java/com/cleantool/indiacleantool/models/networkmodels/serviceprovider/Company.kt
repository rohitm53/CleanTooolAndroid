package com.cleantool.indiacleantool.models.networkmodels.serviceprovider


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Company(
    val address: String,
    val companyCode: String,
    val companyName: String,
    val email: String,
    val id: Int,
    val latitude: Double,
    val longitude: Double
) : Serializable