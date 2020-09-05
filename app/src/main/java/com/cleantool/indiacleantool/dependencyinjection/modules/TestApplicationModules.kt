package com.cleantool.indiacleantool.dependencyinjection.modules

import com.cleantool.indiacleantool.dependencyinjection.DieselEngine
import com.cleantool.indiacleantool.dependencyinjection.Engine
import com.cleantool.indiacleantool.dependencyinjection.PetrolEngine
import dagger.Module
import dagger.Provides

@Module
class TestApplicationModules {

    @Provides
    fun providesDieselEngin(dieselEngine: DieselEngine) : Engine {
        return dieselEngine
    }

}