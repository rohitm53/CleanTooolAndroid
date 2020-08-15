package com.cleantool.indiacleantool.appmodules.login

import android.content.Intent
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.dashboard.DashboardActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.base_activity.*

class LoginActivity : BaseActivity() {
    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_login,ll_body,true)
        hideToolbar()

        btn_signin.setOnClickListener {
            moveToLogin()
        }
    }

    private fun moveToLogin(){
        val intent = Intent(this,DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }
}