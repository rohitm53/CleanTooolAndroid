package com.cleantool.indiacleantool.appmodules.welcomscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.login.LoginActivity
import com.cleantool.indiacleantool.appmodules.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_welcome_screen.*
import kotlinx.android.synthetic.main.base_activity.*

class WelcomeScreenActivity : BaseActivity() {

    override fun initialize() {
        hideToolbar()
        layoutInflater.inflate(R.layout.activity_welcome_screen,ll_body,true)

        btn_signin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        btn_signup.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}