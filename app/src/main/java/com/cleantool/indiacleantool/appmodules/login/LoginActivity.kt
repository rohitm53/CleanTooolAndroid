package com.cleantool.indiacleantool.appmodules.login

import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.dashboard.DashboardActivity
import com.cleantool.indiacleantool.appmodules.signup.SignUpActivity
import com.cleantool.indiacleantool.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.base_activity.*

class LoginActivity : BaseActivity() {

    private lateinit var loginViewModal: LoginViewModal

    override fun initialize() {

        hideToolbar()
        val activityLoginBinding = DataBindingUtil.inflate<ActivityLoginBinding>(
            layoutInflater,
            R.layout.activity_login,
            ll_body,
            true
        )
        loginViewModal = ViewModelProvider(this).get(LoginViewModal::class.java)
        activityLoginBinding.apply {
            viewmodal=loginViewModal
        }

        loginViewModal.liveDataStatus.observe<LoginViewModal.LoginStatus>(this, { loginStatus ->
            when (loginStatus.status) {
                LoginViewModal.SHOW_LOADER -> {
                    showLoader(loginStatus.data.toString())
                }

                LoginViewModal.HIDE_LOADER -> {
                    hideLoader()
                }

                LoginViewModal.SUCCESS -> {
                    hideLoader()
                    moveToDashboard()
                }

                LoginViewModal.ERROR -> {
                    hideLoader()
                    showToast("Error")
                }

                LoginViewModal.NAVIGATE_TO_SIGNUP -> {
                    moveToSignUp()
                }
                else -> showToast("Error")
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