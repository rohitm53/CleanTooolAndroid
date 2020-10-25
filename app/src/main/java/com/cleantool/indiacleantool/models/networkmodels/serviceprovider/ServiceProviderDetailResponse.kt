package com.cleantool.indiacleantool.models.networkmodels.serviceprovider

import com.cleantool.indiacleantool.models.networkmodels.common.Error


data class ServiceProviderDetailResponse(
    val serviceProviderCompanyDetails: List<ServiceProviderCompanyDetail>,
    val error : Error
)