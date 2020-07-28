package com.cleantool.indiacleantool.appmodules.dashboard

import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.utils.viewpagertransformer.ZoomOutPageTransformer
import com.romainpiel.shimmer.Shimmer
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.base_activity.*

class DashboardActivity : BaseActivity() {

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_dashboard,ll_body,true)
        shimmerTextDisplay()

        viewpager.setPageTransformer(ZoomOutPageTransformer())
        viewpager.adapter = DashboardPagerAdapter(this)

    }

    private fun shimmerTextDisplay(){
        val shimmer = Shimmer()
        shimmer.start(tv_msg)
        shimmer.duration = 3000
    }

}