package com.cleantool.indiacleantool.appmodules.confirmationscreen

import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import kotlinx.android.synthetic.main.base_activity.*

class ConfirmationScreenActivity : BaseActivity() {
    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_welcome_screen,ll_body,true)
    }
}