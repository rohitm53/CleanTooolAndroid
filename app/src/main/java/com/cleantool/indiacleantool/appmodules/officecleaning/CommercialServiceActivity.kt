package com.cleantool.indiacleantool.appmodules.officecleaning

import android.content.res.Resources
import androidx.constraintlayout.widget.ConstraintLayout
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import kotlinx.android.synthetic.main.activity_household_service.*
import kotlinx.android.synthetic.main.base_activity.*

class CommercialServiceActivity : BaseActivity(){

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_commercial_service,ll_body,true)
        setMapFrameHeight()
    }

    private fun setMapFrameHeight(){
        val screenHeight= Resources.getSystem().displayMetrics.heightPixels
        val mapHeight = ((screenHeight*50)/100)
        frameLayout.layoutParams= ConstraintLayout.LayoutParams(0,mapHeight)
    }
}