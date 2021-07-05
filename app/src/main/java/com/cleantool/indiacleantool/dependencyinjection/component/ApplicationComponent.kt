package com.cleantool.indiacleantool.dependencyinjection.component

import com.cleantool.indiacleantool.appmodules.dashboard.history.DashboardHistoryViewModal
import com.cleantool.indiacleantool.appmodules.login.LoginViewModal
import com.cleantool.indiacleantool.appmodules.login.repository.LoginRepository
import com.cleantool.indiacleantool.appmodules.servicebooking.BookServiceViewModal
import com.cleantool.indiacleantool.appmodules.serviceprovider.data.ServiceProviderCompanyRespository
import com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidecompanydetails.ServiceProviderCompanyDetailViewModel
import com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidercompanylist.ServiceProviderCompanyListViewModal
import com.cleantool.indiacleantool.appmodules.signup.SignUpViewModal
import com.cleantool.indiacleantool.appmodules.signup.service.SignUpRepository
import com.cleantool.indiacleantool.dependencyinjection.modules.ApplicationModules
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModules::class])
interface ApplicationComponent {

    fun inject(loginRepository: LoginRepository)
    fun inject(signUpRepository: SignUpRepository)
    fun inject(loginViewModal: LoginViewModal)
    fun inject(signUpViewModal: SignUpViewModal)
    fun inject(serviceProviderCompanyListViewModal: ServiceProviderCompanyListViewModal)
    fun inject(serviceProviderCompanyDetailViewModel: ServiceProviderCompanyDetailViewModel)
    fun inject(serviceProviderCompanyRespository: ServiceProviderCompanyRespository)


    fun inject(bookServiceViewModal: BookServiceViewModal)


    fun inject(dashboardHistoryViewModal: DashboardHistoryViewModal)


}