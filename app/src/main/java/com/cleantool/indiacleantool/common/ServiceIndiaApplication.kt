package com.cleantool.indiacleantool.common

import android.app.Application
import com.cleantool.indiacleantool.dependencyinjection.component.ApplicationComponent
import com.cleantool.indiacleantool.dependencyinjection.component.DaggerApplicationComponent

class ServiceIndiaApplication : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                              .provideProvidePowerCapacity(100)
                              .provideEngineCapacity(500)
                              .build()
    }


    fun getApplicationComponent():ApplicationComponent {
        return applicationComponent
    }



}