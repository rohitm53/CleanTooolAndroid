package com.cleantool.indiacleantool.appmodules.bookingconfirmation

import android.content.Intent
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.dashboard.DashboardActivity
import kotlinx.android.synthetic.main.activity_booking_confirmation.*
import kotlinx.android.synthetic.main.base_activity.*

class BookingConfirmationActivity : BaseActivity() {

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_booking_confirmation,ll_body,true)

        btn_back_to_home.setOnClickListener {
            val intent = Intent(this,DashboardActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

    }
}