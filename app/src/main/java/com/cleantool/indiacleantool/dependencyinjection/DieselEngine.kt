package com.cleantool.indiacleantool.dependencyinjection

import android.util.Log
import javax.inject.Inject

class DieselEngine : Engine {

    @Inject
    constructor()

    override fun start() {
        Log.d("cleanlogs","Diesle Engine start")
    }

}