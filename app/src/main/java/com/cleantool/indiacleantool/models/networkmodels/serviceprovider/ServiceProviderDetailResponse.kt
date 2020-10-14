package com.cleantool.indiacleantool.models.networkmodels.serviceprovider


data class ServiceProviderDetailResponse(
    val serviceProviderCompanyDetails: List<ServiceProviderCompanyDetail>,
    val error : Error
)