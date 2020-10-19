package com.cleantool.indiacleantool.appmodules.serviceprovider.listner

import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderCompanyDetail

interface ServiceProviderListner {

    fun moveToServiceDetails(serviceProviderCompanyDetail: ServiceProviderCompanyDetail)
}