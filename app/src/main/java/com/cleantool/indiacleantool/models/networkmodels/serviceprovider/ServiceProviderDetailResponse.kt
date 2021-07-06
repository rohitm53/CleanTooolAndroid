package com.cleantool.indiacleantool.models.networkmodels.serviceprovider

import com.cleantool.indiacleantool.models.networkmodels.common.Error
import com.google.gson.annotations.SerializedName


data class ServiceProviderDetailResponse(

    @SerializedName("company-details")
    val companyDetails: List<ServiceProviderCompany>,
    val error : Error

)