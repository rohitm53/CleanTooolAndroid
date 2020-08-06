package com.cleantool.indiacleantool.appmodules.officecleaning

import android.content.res.Resources
import androidx.constraintlayout.widget.ConstraintLayout
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import kotlinx.android.synthetic.main.activity_home_cleaning.*
import kotlinx.android.synthetic.main.base_activity.*

class OfficeCleaningActivity : BaseActivity(){

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_office_cleaning,ll_body,true)
        setMapFrameHeight()
    }

    private fun setMapFrameHeight(){
        val screenHeight= Resources.getSystem().displayMetrics.heightPixels
        val mapHeight = ((screenHeight*50)/100)
        frameLayout.layoutParams= ConstraintLayout.LayoutParams(0,mapHeight)
    }
}