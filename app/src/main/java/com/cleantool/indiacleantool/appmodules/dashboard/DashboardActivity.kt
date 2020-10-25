package com.cleantool.indiacleantool.appmodules.dashboard

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.dashboard.settings.ServiceSelectorListner
import com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidecompanydetails.ServiceProviderCompanyDetailActivity
import com.cleantool.indiacleantool.appmodules.serviceprovider.serviceprovidercompanylist.ServiceProviderListActivity
import com.cleantool.indiacleantool.common.IntentKey
import com.cleantool.indiacleantool.customdialog.servicedialog.CustomServiceGridDialog
import com.cleantool.indiacleantool.utils.viewpagertransformer.ZoomOutPageTransformer
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.base_activity.*

class DashboardActivity : BaseActivity() , ServiceTypeSelectorListner {

    val viewModal : DashboardActivityViewModal by viewModels()

    private lateinit var customServiceGridDialog:CustomServiceGridDialog


    override fun initialize() {

        layoutInflater.inflate(R.layout.activity_dashboard,ll_body,true)

        viewpager.setPageTransformer(ZoomOutPageTransformer())
        viewpager.adapter = DashboardPagerAdapter(this,this)


        viewpager.registerOnPageChangeCallback( object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                if(position==0){
                    bottom_navigation_view.selectedItemId = R.id.menu_home
                }else if(position==1){
                    bottom_navigation_view.selectedItemId = R.id.menu_search
                }else if(position==2){
                    bottom_navigation_view.selectedItemId = R.id.menu_history
                }else if(position==3){
                    bottom_navigation_view.selectedItemId = R.id.menu_settings
                }
            }
        })

        bottom_navigation_view.setOnNavigationItemSelectedListener {menuItem: MenuItem ->
            return@setOnNavigationItemSelectedListener  when(menuItem.itemId){
                R.id.menu_home -> {
                    viewpager.setCurrentItem(0)
                    true
                }
                R.id.menu_search -> {
                    viewpager.setCurrentItem(1)
                    true
                }
                R.id.menu_history -> {
                    viewpager.setCurrentItem(2)
                    true
                }
                R.id.menu_settings -> {
                    viewpager.setCurrentItem(3)
                    true
                }
                else -> false
            }
        }
    }

    override fun openServicePopup(serviceType: String) {
        showServiceByTypePopup(serviceType)
    }

    fun showServiceByTypePopup(serviceType: String){

        if(this::customServiceGridDialog.isInitialized && customServiceGridDialog.isShowing){
            customServiceGridDialog.dismiss()
        }

        customServiceGridDialog = CustomServiceGridDialog(
            this,
            viewModal.hmServices.get(serviceType)!!,
            object : ServiceSelectorListner {
                override fun moveToProvidingCompanyList(serviceCode: String) {

                    this@DashboardActivity.customServiceGridDialog.dismiss()
                    this@DashboardActivity.showLoader("Loading...")
                    Handler().postDelayed({
                        this@DashboardActivity.hideLoader()
                        this@DashboardActivity.moveToProviderCompanylist(serviceCode,serviceType)
                    }, 1000)
                }

            })

        customServiceGridDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customServiceGridDialog.setCancelable(true)
        customServiceGridDialog.show();
    }



    fun moveToProviderCompanylist(serviceCode: String,serviceType: String) {
        val intent = Intent(this, ServiceProviderListActivity::class.java)
        intent.putExtra(IntentKey.ServiceCode,serviceCode)
        intent.putExtra(IntentKey.ServiceType,serviceType)
        startActivity(intent)
    }

}