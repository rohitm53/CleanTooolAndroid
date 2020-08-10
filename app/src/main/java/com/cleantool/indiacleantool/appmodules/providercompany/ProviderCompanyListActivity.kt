package com.cleantool.indiacleantool.appmodules.providercompany

import android.content.res.Resources
import androidx.constraintlayout.widget.ConstraintLayout
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import kotlinx.android.synthetic.main.activity_provider_company_list_activity.*
import kotlinx.android.synthetic.main.base_activity.*

class ProviderCompanyListActivity : BaseActivity() {

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_provider_company_list_activity,ll_body,true)
        setMapFrameHeight()
    }

    private fun setMapFrameHeight(){
        val screenHeight= Resources.getSystem().displayMetrics.heightPixels
        val mapHeight = ((screenHeight*50)/100)
        frameLayout.layoutParams= ConstraintLayout.LayoutParams(0,mapHeight)
    }
}