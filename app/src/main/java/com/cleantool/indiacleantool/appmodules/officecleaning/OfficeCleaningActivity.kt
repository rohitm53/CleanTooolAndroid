package com.cleantool.indiacleantool.appmodules.officecleaning

import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import kotlinx.android.synthetic.main.base_activity.*

class OfficeCleaningActivity : BaseActivity(){

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_office_cleaning,ll_body,true)
    }
}