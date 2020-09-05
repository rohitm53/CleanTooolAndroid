package com.cleantool.indiacleantool.dependencyinjection

import android.util.Log
import javax.inject.Inject

class PetrolEngine : Engine {

    var powerCapacity:Int
    var engineCapacity:Int

    @Inject
    constructor(powerCapacity : Int,engineCapacity:Int){
        this.powerCapacity=powerCapacity
        this.engineCapacity=engineCapacity
    }


    override fun start() {
        Log.d("cleanlogs","Petrol Engine start with power capacity : "+powerCapacity)
        Log.d("cleanlogs","Petrol Engine start with engine capacity : "+engineCapacity)
    }

}