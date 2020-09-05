package com.cleantool.indiacleantool.dependencyinjection

import android.util.Log
import javax.inject.Inject
import javax.inject.Named

class PetrolEngine : Engine {

    var powerCapacity:Int
    var engineCapacity:Int

    @Inject
    constructor(@Named("powerCapacity")powerCapacity : Int, @Named("engineCapacity")engineCapacity:Int){
        this.powerCapacity=powerCapacity
        this.engineCapacity=engineCapacity
    }


    override fun start() {
        Log.d("cleanlogs","Petrol Engine start with power capacity : "+powerCapacity)
        Log.d("cleanlogs","Petrol Engine start with engine capacity : "+engineCapacity)
    }

}