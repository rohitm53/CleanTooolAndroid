package com.cleantool.indiacleantool.appmodules.login

import android.content.Intent
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.dashboard.DashboardActivity
import com.cleantool.indiacleantool.appmodules.signup.SignUpActivity
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.dependencyinjection.Car
import com.cleantool.indiacleantool.dependencyinjection.Engine
import com.cleantool.indiacleantool.dependencyinjection.Wheels
import com.cleantool.indiacleantool.dependencyinjection.component.DaggerApplicationComponent
import com.cleantool.indiacleantool.dependencyinjection.modules.ApplicationModules
import com.cleantool.indiacleantool.models.Book
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.base_activity.*
import javax.inject.Inject

class LoginActivity : BaseActivity() {

    @Inject
    lateinit var car: Car

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_login,ll_body,true)
        hideToolbar()
        btn_signin.setOnClickListener {
            moveToLogin()
        }

        tv_not_you.setOnClickListener {
            moveToSignUp()
        }

        (application as ServiceIndiaApplication).getApplicationComponent().inject(this)

        car.start()
        car.engine.start()
        car.wheels.start()

    }

    private fun moveToLogin(){
        val intent = Intent(this,DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun moveToSignUp(){
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }
}