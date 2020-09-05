package com.cleantool.indiacleantool.dependencyinjection.component

import com.cleantool.indiacleantool.appmodules.login.LoginActivity
import com.cleantool.indiacleantool.dependencyinjection.Car
import com.cleantool.indiacleantool.dependencyinjection.modules.ApplicationModules
import com.cleantool.indiacleantool.dependencyinjection.modules.TestApplicationModules
import com.cleantool.indiacleantool.dependencyinjection.modules.WheelsModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = arrayOf(ApplicationModules::class,WheelsModule::class))
interface ApplicationComponent {

    fun getCar() : Car

    fun inject(loginActivity: LoginActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun provideProvidePowerCapacity(powerCapacity : Int) : Builder

        fun build() : ApplicationComponent

    }
}