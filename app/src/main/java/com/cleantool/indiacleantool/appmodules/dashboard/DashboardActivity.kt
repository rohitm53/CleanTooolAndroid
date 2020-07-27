package com.cleantool.indiacleantool.appmodules.dashboard

import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import kotlinx.android.synthetic.main.base_activity.*

class DashboardActivity : BaseActivity() {

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_dashboard,ll_body,true)
    }
}