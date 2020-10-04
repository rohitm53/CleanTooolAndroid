package com.cleantool.indiacleantool.common

import android.app.Application
import com.cleantool.indiacleantool.dependencyinjection.component.ApplicationComponent
import com.cleantool.indiacleantool.dependencyinjection.component.DaggerApplicationComponent
import com.cleantool.indiacleantool.dependencyinjection.modules.ApplicationModules

class ServiceIndiaApplication : Application() {

    companion object {

        private lateinit var applicationComponent: ApplicationComponent
        private lateinit var serviceIndiaApplication: ServiceIndiaApplication

        fun getApplicationComponent(): ApplicationComponent {
            return applicationComponent
        }

        fun getServiceIndiaApplication():ServiceIndiaApplication {
            return serviceIndiaApplication
        }
    }


    override fun onCreate() {
        super.onCreate()
        serviceIndiaApplication=this

        applicationComponent = DaggerApplicationComponent.builder()
                              .applicationModules(ApplicationModules(serviceIndiaApplication))
                              .build()

    }



}