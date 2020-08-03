package com.cleantool.indiacleantool.appmodules.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cleantool.indiacleantool.appmodules.dashboard.home.DashboardHomeFragment

class DashboardPagerAdapter : FragmentStateAdapter {

    private var cleanTypeSelectorListner: CleanTypeSelectorListner
    private val NUM_PAGES=4

    constructor(fragmentActivity: FragmentActivity,cleanTypeSelectorListner: CleanTypeSelectorListner):super(fragmentActivity) {
        this.cleanTypeSelectorListner=cleanTypeSelectorListner
    }

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return DashboardHomeFragment(cleanTypeSelectorListner)
    }
}