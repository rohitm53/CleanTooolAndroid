package com.cleantool.indiacleantool.appmodules.dashboard

import android.content.Intent
import android.widget.PopupMenu
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.homecleaning.HouseholdServiceActivity
import com.cleantool.indiacleantool.appmodules.officecleaning.CommercialServiceActivity
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

        val popupMenu=PopupMenu(this,layoutInflater.inflate(R.layout.service_hover_menu,null,false))

        popupMenu.show()
    }

}