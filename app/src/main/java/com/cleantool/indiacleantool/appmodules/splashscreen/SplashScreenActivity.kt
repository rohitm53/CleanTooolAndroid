package com.cleantool.indiacleantool.appmodules.splashscreen

import android.content.Intent
import android.os.Handler
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.login.LoginActivity
import kotlinx.android.synthetic.main.base_activity.*

class SplashScreenActivity : BaseActivity() {

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_splash_screen,ll_body,true)

        Handler().postDelayed({
            navigateToLogin()
        },2000);
    }

    private fun navigateToLogin(){
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
    }
}