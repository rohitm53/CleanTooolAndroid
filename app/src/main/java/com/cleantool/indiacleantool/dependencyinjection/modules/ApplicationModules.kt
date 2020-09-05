package com.cleantool.indiacleantool.dependencyinjection.modules

import com.cleantool.indiacleantool.dependencyinjection.Engine
import com.cleantool.indiacleantool.dependencyinjection.PetrolEngine
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
 class ApplicationModules {

    @Provides
    fun providesPetrolEngin(petrolEngine: PetrolEngine) : Engine{
        return petrolEngine
    }

}