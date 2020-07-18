package com.cleantool.indiacleantool.appmodules.commonmodule

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.cleantool.indiacleantool.R

abstract class BaseActivity : AppCompatActivity() {

    abstract fun initialize()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)

        initialize()
    }

    fun handleToolbar(){

    }

}