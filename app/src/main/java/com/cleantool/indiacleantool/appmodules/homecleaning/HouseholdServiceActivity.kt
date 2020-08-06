package com.cleantool.indiacleantool.appmodules.homecleaning

import android.content.Intent
import android.content.res.Resources
import androidx.constraintlayout.widget.ConstraintLayout
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.servicecompany.ConfirmationScreenActivity
import kotlinx.android.synthetic.main.activity_household_service.*
import kotlinx.android.synthetic.main.base_activity.*

class HouseholdServiceActivity : BaseActivity() {


    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_household_service,ll_body,true)
        setMapFrameHeight()

        btn_continue.setOnClickListener {
            val intent = Intent(this,ConfirmationScreenActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setMapFrameHeight(){
        val screenHeight=Resources.getSystem().displayMetrics.heightPixels
        val mapHeight = ((screenHeight*50)/100)
        frameLayout.layoutParams= ConstraintLayout.LayoutParams(0,mapHeight)
    }

}