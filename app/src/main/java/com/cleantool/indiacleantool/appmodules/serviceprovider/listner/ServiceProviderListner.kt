package com.cleantool.indiacleantool.appmodules.serviceprovider.listner

import com.cleantool.indiacleantool.models.networkmodels.serviceprovider.ServiceProviderCompany

interface ServiceProviderListner {

    fun moveToServiceDetails(serviceProviderCompany: ServiceProviderCompany)
}