package com.cleantool.indiacleantool.dependencyinjection.modules

import android.util.Log
import com.cleantool.indiacleantool.dependencyinjection.Rims
import com.cleantool.indiacleantool.dependencyinjection.Tyres
import com.cleantool.indiacleantool.dependencyinjection.Wheels
import dagger.Module
import dagger.Provides

@Module
class WheelsModule {

    @Provides
    fun provideRims() : Rims {
        Log.d("cleanlogs","Rims created....")
        return Rims()
    }

    @Provides
    fun provideTyres() : Tyres {
        Log.d("cleanlogs","Tyres created....")
        return Tyres()
    }


    @Provides
    fun providesWheels(rims: Rims,tyres: Tyres) : Wheels{
        Log.d("cleanlogs","Wheels created....")
        return  Wheels(rims,tyres)
    }

}