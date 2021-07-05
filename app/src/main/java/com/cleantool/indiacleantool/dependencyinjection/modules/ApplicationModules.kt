package com.cleantool.indiacleantool.dependencyinjection.modules

import androidx.room.Room
import com.cleantool.indiacleantool.appmodules.dashboard.data.DashboardApi
import com.cleantool.indiacleantool.appmodules.dashboard.history.DashboardHistoryRepository
import com.cleantool.indiacleantool.appmodules.login.service.LoginService
import com.cleantool.indiacleantool.appmodules.servicebooking.data.BookServiceApi
import com.cleantool.indiacleantool.appmodules.servicebooking.data.BookServiceRepository
import com.cleantool.indiacleantool.appmodules.serviceprovider.data.ServiceProviderCompanyApi
import com.cleantool.indiacleantool.appmodules.serviceprovider.data.ServiceProviderCompanyRespository
import com.cleantool.indiacleantool.common.Preference
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.common.ServiceUrls
import com.cleantool.indiacleantool.database.AppDatabase
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


    @Singleton
    @Provides
    fun provideRoomDatabase(): AppDatabase {
        return Room.databaseBuilder(
            serviceIndiaApplication,
            AppDatabase::class.java,"my-database"
        ).build()

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
    fun provideServiceProvideCompanyService(retrofit: Retrofit) : ServiceProviderCompanyApi {
        return retrofit.create(ServiceProviderCompanyApi::class.java)
    }

    @Singleton
    @Provides
    fun provideServiceProvideCompanyRepository() : ServiceProviderCompanyRespository {
        return ServiceProviderCompanyRespository()
    }


    @Singleton
    @Provides
    fun provideBookServiceRepository(retrofit: Retrofit,appDatabase: AppDatabase,preference: Preference): BookServiceRepository {
        return BookServiceRepository(retrofit.create(BookServiceApi::class.java),appDatabase,preference)
    }

    @Singleton
    @Provides
    fun provideDashboardServiceApi(retrofit: Retrofit) : DashboardApi {
        return retrofit.create(DashboardApi::class.java)
    }

    @Singleton
    @Provides
    fun provideDashboardRepository(dashboardApi: DashboardApi,preference: Preference) : DashboardHistoryRepository{
        return DashboardHistoryRepository(dashboardApi,preference)
    }


}