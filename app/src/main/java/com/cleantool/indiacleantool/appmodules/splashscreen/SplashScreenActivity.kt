package com.cleantool.indiacleantool.appmodules.splashscreen

import android.content.Intent
import android.os.Handler
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.welcomscreen.WelcomeScreenActivity
import kotlinx.android.synthetic.main.base_activity.*

class SplashScreenActivity : BaseActivity() {

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_splash_screen,ll_body,true)
        hideToolbar()
        showLoader("Initialising...")
        Handler().postDelayed({navigateToLogin()},3000)
    }

    private fun navigateToLogin(){
        val intent = Intent(this, WelcomeScreenActivity::class.java)
        startActivity(intent)
    }
}