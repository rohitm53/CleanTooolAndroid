package com.cleantool.indiacleantool.appmodules.confirmationscreen

import android.content.Intent
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.bookingconfirmation.BookingConfirmationActivity
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import kotlinx.android.synthetic.main.activity_confirmation_screen.*
import kotlinx.android.synthetic.main.base_activity.*

class ConfirmationScreenActivity : BaseActivity() {
    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_confirmation_screen,ll_body,true)


        btn_book.setOnClickListener {
            val intent = Intent(this,BookingConfirmationActivity::class.java)
            startActivity(intent)
        }
    }
}