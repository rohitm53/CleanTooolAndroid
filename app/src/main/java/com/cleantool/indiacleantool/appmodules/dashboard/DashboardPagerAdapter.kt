package com.cleantool.indiacleantool.appmodules.dashboard

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cleantool.indiacleantool.appmodules.dashboard.history.DashboardHistoryFragment
import com.cleantool.indiacleantool.appmodules.dashboard.home.DashboardHomeFragment
import com.cleantool.indiacleantool.appmodules.dashboard.search.DashboardSearchFragment
import com.cleantool.indiacleantool.appmodules.dashboard.settings.DashboardSettingsFragment

class DashboardPagerAdapter : FragmentStateAdapter {

    private var serviceTypeSelectorListner: ServiceTypeSelectorListner
    private val NUM_PAGES=4

    constructor(fragmentActivity: FragmentActivity, serviceTypeSelectorListner: ServiceTypeSelectorListner):super(fragmentActivity) {
        this.serviceTypeSelectorListner=serviceTypeSelectorListner
    }

    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        if(position==0){
            return DashboardHomeFragment(serviceTypeSelectorListner)
        }else if(position==1){
            return DashboardSearchFragment()
        }else if(position==2){
            return DashboardHistoryFragment()
        }else {
            return DashboardSettingsFragment()
        }
    }
}