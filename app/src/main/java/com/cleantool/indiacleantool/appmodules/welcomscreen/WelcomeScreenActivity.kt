package com.cleantool.indiacleantool.appmodules.welcomscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.login.LoginActivity
import com.cleantool.indiacleantool.appmodules.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_welcome_screen.*

class WelcomeScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

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