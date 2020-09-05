package com.cleantool.indiacleantool.common

import android.app.Application
import com.cleantool.indiacleantool.dependencyinjection.component.ApplicationComponent
import com.cleantool.indiacleantool.dependencyinjection.component.DaggerApplicationComponent
import com.cleantool.indiacleantool.dependencyinjection.modules.ApplicationModules

class ServiceIndiaApplication : Application() {

    companion object {
        private lateinit var applicationComponent: ApplicationComponent

        fun getApplicationComponent() : ApplicationComponent{
            return applicationComponent
        }
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                              .provideProvidePowerCapacity(100)
                              .build()
    }




}