package com.cleantool.indiacleantool.dependencyinjection.modules

import com.cleantool.indiacleantool.appmodules.login.repository.LoginRepository
import com.cleantool.indiacleantool.appmodules.login.service.LoginService
import com.cleantool.indiacleantool.appmodules.providercompany.ServiceProviderCompanyRespository
import com.cleantool.indiacleantool.appmodules.providercompany.serviceApi.ServiceProviderCompanyApi
import com.cleantool.indiacleantool.common.Preference
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.common.ServiceUrls
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
 class ApplicationModules(private var serviceIndiaApplication: ServiceIndiaApplication) {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ServiceUrls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideGson() : Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideLoginService(retrofit: Retrofit): LoginService {
        return retrofit.create(LoginService::class.java)
    }

    @Singleton
    @Provides
    fun provideSharedPrefference() : Preference{
        return Preference(serviceIndiaApplication)
    }

    @Singleton
    @Provides
    fun provideLoginRepository(): LoginRepository {
        return  LoginRepository()
    }

    @Singleton
    @Provides
    fun provideServiceProvideCompanyService(retrofit: Retrofit) : ServiceProviderCompanyApi{
        return retrofit.create(ServiceProviderCompanyApi::class.java)
    }

    @Singleton
    @Provides
    fun provideServiceProvideCompanyRepository() : ServiceProviderCompanyRespository{
        return ServiceProviderCompanyRespository()
    }

}