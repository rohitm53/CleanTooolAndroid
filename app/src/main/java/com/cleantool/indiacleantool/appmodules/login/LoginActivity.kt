package com.cleantool.indiacleantool.appmodules.login

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.dashboard.DashboardActivity
import com.cleantool.indiacleantool.appmodules.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.base_activity.*

class LoginActivity : BaseActivity() {

    private lateinit var loginViewModal: LoginViewModal

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_login,ll_body,true)
        hideToolbar()

        loginViewModal = ViewModelProvider(this).get(LoginViewModal::class.java)

        btn_signin.setOnClickListener {
            showLoader("Logging in...")
            loginViewModal.authenticateUser("rohit","password")
            moveToDashboard()
        }
        tv_not_you.setOnClickListener {
            moveToSignUp()
        }

        loginViewModal.liveDataStatus.observe(this,{
            when(it){
                LoginViewModal.Companion.Status.SUCCESS -> {
                    hideLoader()
                    moveToDashboard()
                }
                LoginViewModal.Companion.Status.ERROR -> {
                    hideLoader()
                    showToast("Error")
                }
            }
        })

    }

    private fun moveToDashboard(){
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