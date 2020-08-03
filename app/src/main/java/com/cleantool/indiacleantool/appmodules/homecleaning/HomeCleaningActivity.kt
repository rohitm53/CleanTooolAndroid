package com.cleantool.indiacleantool.appmodules.homecleaning

import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.constraintlayout.widget.ConstraintLayout
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.servicecompany.ServiceCompanyListActivity
import kotlinx.android.synthetic.main.activity_home_cleaning.*
import kotlinx.android.synthetic.main.base_activity.*

class HomeCleaningActivity : BaseActivity() {


    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_home_cleaning,ll_body,true)
        setMapFrameHeight()

        seekbar_price.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
                tv_price_range.text = ("Price : "+progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })
        btn_continue.setOnClickListener {
            val intent = Intent(this,ServiceCompanyListActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setMapFrameHeight(){
        val screenHeight=Resources.getSystem().displayMetrics.heightPixels
        val mapHeight = ((screenHeight*50)/100)
        frameLayout.layoutParams= ConstraintLayout.LayoutParams(0,mapHeight)
    }

}