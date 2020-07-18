package com.cleantool.indiacleantool.appmodules.login

import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import kotlinx.android.synthetic.main.base_activity.*

class LoginActivity : BaseActivity() {
    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_login,ll_body,true)
        toolbar.title="This is Login Screen"
    }
}