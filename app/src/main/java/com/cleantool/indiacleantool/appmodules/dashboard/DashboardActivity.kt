package com.cleantool.indiacleantool.appmodules.dashboard

import android.content.Intent
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.homecleaning.HomeCleaningActivity
import com.cleantool.indiacleantool.appmodules.officecleaning.OfficeCleaningActivity
import com.cleantool.indiacleantool.common.Constants
import com.cleantool.indiacleantool.utils.viewpagertransformer.ZoomOutPageTransformer
import com.romainpiel.shimmer.Shimmer
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.base_activity.*

class DashboardActivity : BaseActivity() , CleanTypeSelectorListner {

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_dashboard,ll_body,true)
        shimmerTextDisplay()

        viewpager.setPageTransformer(ZoomOutPageTransformer())
        viewpager.adapter = DashboardPagerAdapter(this,this)


    }

    private fun shimmerTextDisplay(){
        val shimmer = Shimmer()
        shimmer.start(tv_msg)
        shimmer.duration = 3000
    }

    override fun moveToSelectedCleaningActvity(cleaning_code: String) {
        when(cleaning_code){
            Constants.Home_Cleaning -> {
                val intent = Intent(this,HomeCleaningActivity::class.java)
                startActivity(intent)
            }

            Constants.Office_Cleaning -> {
                val intent = Intent(this,OfficeCleaningActivity::class.java)
                startActivity(intent)
            }

            Constants.Move_In_Cleaning -> {
            }
            Constants.Move_Out_Cleaning -> {
            }
            Constants.Laundary -> {
            }

        }

    }

}