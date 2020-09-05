package com.cleantool.indiacleantool.dependencyinjection

import android.util.Log
import javax.inject.Inject

class Car {

    @Inject
    lateinit var wheels: Wheels
    lateinit var engine: Engine

    @Inject
    constructor(engine: Engine){
        this.engine=engine
    }

    fun start(){
        Log.d("cleanlogs","Car driving....")
    }

}