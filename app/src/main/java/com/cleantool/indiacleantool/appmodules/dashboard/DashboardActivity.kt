package com.cleantool.indiacleantool.appmodules.dashboard

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.common.Constants
import com.cleantool.indiacleantool.customdialog.servicedialog.CustomServiceGridDialog
import com.cleantool.indiacleantool.models.services.Service
import com.cleantool.indiacleantool.utils.viewpagertransformer.ZoomOutPageTransformer
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.base_activity.*

class DashboardActivity : BaseActivity() , ServiceTypeSelectorListner {

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
        showHouseholdServicePopUp(serviceType)
    }

    fun showHouseholdServicePopUp(serviceType: String){
        val customServiceGridDialog = CustomServiceGridDialog(this,getServiceDataByType(serviceType))
        customServiceGridDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customServiceGridDialog.setCancelable(true)
        customServiceGridDialog.show();
    }

    private fun getServiceDataByType(serviceType: String) : List<Service>{
        val listService = ArrayList<Service>();

        if(serviceType.equals(Constants.House_Hold_Type,true)){
            var service = Service(1,"UT","Utensils",R.drawable.utensils);
            listService.add(service);

            service = Service(1,"MPB","Mopping/Brooming",R.drawable.mopping);
            listService.add(service);

            service = Service(1,"BTH","Bathroom",R.drawable.bathroom);
            listService.add(service);

            service = Service(1,"TLT","Toilet",R.drawable.toilet);
            listService.add(service);

        }else if(serviceType.equals(Constants.Commercial_Type,true)){

            var service = Service(1,"KT","Kitchen",R.drawable.kitchen);
            listService.add(service);

            service = Service(1,"OFC","Office",R.drawable.office);
            listService.add(service);

            service = Service(1,"WRH","Warehouse",R.drawable.warehouse);
            listService.add(service);


        }else if(serviceType.equals(Constants.Laundary_Type)){
            var service = Service(1,"CLTH","Clothes",R.drawable.clothes);
            listService.add(service);

            service = Service(1,"DRCLNG","Dry Cleaning",R.drawable.dry_cleaning);
            listService.add(service);

            service = Service(1,"IRNG","Ironing",R.drawable.ironing);
            listService.add(service);
        }

        return listService;
    }

}