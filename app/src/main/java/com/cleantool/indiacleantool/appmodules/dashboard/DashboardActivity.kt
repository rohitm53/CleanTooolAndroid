package com.cleantool.indiacleantool.appmodules.dashboard

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.core.content.ContextCompat
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.providercompany.ProviderCompanyListActivity
import com.cleantool.indiacleantool.common.Constants
import com.cleantool.indiacleantool.utils.viewpagertransformer.ZoomOutPageTransformer
import com.romainpiel.shimmer.Shimmer
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.base_activity.*

class DashboardActivity : BaseActivity() , CleanTypeSelectorListner {

    private  var popupWindow: PopupWindow?=null;

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_dashboard,ll_body,true)
        viewpager.setPageTransformer(ZoomOutPageTransformer())
        viewpager.adapter = DashboardPagerAdapter(this,this)

    }


    override fun moveToSelectedCleaningActvity(view: View, cleaning_code: String) {

        if(popupWindow!=null && popupWindow?.isShowing!!){
            popupWindow?.dismiss()
        }
        when(cleaning_code){
            Constants.House_Hold_Services -> showHouseholdServicePopUp(view)
            Constants.Commercial_Services -> showHouseholdServicePopUp(view)
        }
    }

    override fun onBackPressed() {
        if(popupWindow!=null && popupWindow?.isShowing!!){
            popupWindow?.dismiss()
        }else{
            super.onBackPressed()
        }
    }

    fun showHouseholdServicePopUp(view: View){
        popupWindow = PopupWindow(this)
        popupWindow?.contentView=layoutInflater.inflate(R.layout.service_hover_menu,null)
        popupWindow?.isOutsideTouchable=true

        popupWindow?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        val iv_utensils = popupWindow?.contentView?.findViewById<ImageView>(R.id.iv_utensils)
        val iv_mopping_bromming = popupWindow?.contentView?.findViewById<ImageView>(R.id.iv_mopping_bromming)
        val iv_bathroom = popupWindow?.contentView?.findViewById<ImageView>(R.id.iv_bathroom)
        val iv_toilet = popupWindow?.contentView?.findViewById<ImageView>(R.id.iv_toilet)
        val iv_combine = popupWindow?.contentView?.findViewById<ImageView>(R.id.iv_combine)

        iv_utensils?.setOnClickListener {
            showLoader("Loading...")
            val intent = Intent(this,ProviderCompanyListActivity::class.java)
            startActivity(intent)
            popupWindow?.dismiss()
            hideLoader()
        }
        iv_mopping_bromming?.setOnClickListener {
            showLoader("Loading...")
            val intent = Intent(this,ProviderCompanyListActivity::class.java)
            startActivity(intent)
            popupWindow?.dismiss()
            hideLoader()
        }
        iv_bathroom?.setOnClickListener {
            showLoader("Loading...")
            val intent = Intent(this,ProviderCompanyListActivity::class.java)
            startActivity(intent)
            popupWindow?.dismiss()
            hideLoader()
        }
        iv_toilet?.setOnClickListener {
            showLoader("Loading...")
            val intent = Intent(this,ProviderCompanyListActivity::class.java)
            startActivity(intent)
            popupWindow?.dismiss()
            hideLoader()
        }
        iv_combine?.setOnClickListener {
            showLoader("Loading...")
            val intent = Intent(this,ProviderCompanyListActivity::class.java)
            startActivity(intent)
            popupWindow?.dismiss()
            hideLoader()
        }
        popupWindow?.showAsDropDown(view)
    }

}