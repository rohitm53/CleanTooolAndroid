package com.cleantool.indiacleantool.appmodules.servicecompany

import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import kotlinx.android.synthetic.main.base_activity.*

class ServiceCompanyListActivity : BaseActivity() {
    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_service_company_list,ll_body,true)
    }

}