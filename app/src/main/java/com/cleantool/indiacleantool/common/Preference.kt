package com.cleantool.indiacleantool.common

import android.content.Context
import android.content.SharedPreferences

class Preference(application: ServiceIndiaApplication)  {

    private lateinit var sharedPreferences : SharedPreferences
    private val shareprefferncename = "com.cleantool.indiacleantool.common.mypreference"

    init{
        sharedPreferences = application.getSharedPreferences(shareprefferncename,Context.MODE_PRIVATE)
    }

    fun saveString(key : String , value:String){
        with(sharedPreferences.edit()){
            putString(key,value)
            apply()
        }
    }
    fun getStringValue(key:String) : String{
        return sharedPreferences.getString(key,"")!!
    }


    object Keys {
        const val UserCode="user_code"
        const val JsonWebToken = "jsonwebtoken"
        const val Password = "password"
    }

}