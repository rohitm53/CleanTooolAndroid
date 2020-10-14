package com.cleantool.indiacleantool.dependencyinjection.component

import com.cleantool.indiacleantool.appmodules.login.LoginViewModal
import com.cleantool.indiacleantool.appmodules.login.repository.LoginRepository
import com.cleantool.indiacleantool.appmodules.login.service.LoginService
import com.cleantool.indiacleantool.appmodules.providercompany.ServiceProviderCompanyRespository
import com.cleantool.indiacleantool.appmodules.providercompany.ServiceProviderCompanyViewModel
import com.cleantool.indiacleantool.dependencyinjection.modules.ApplicationModules
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModules::class])
interface ApplicationComponent {

    fun inject(loginRepository: LoginRepository)
    fun inject(loginViewModal: LoginViewModal)

    fun inject(serviceProviderCompanyViewModel: ServiceProviderCompanyViewModel)
    fun inject(serviceProviderCompanyRespository: ServiceProviderCompanyRespository)

}