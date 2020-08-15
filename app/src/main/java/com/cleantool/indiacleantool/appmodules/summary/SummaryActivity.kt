package com.cleantool.indiacleantool.appmodules.summary

import android.content.Intent
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.bookingconfirmation.BookingConfirmationActivity
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import kotlinx.android.synthetic.main.activity_summary.*
import kotlinx.android.synthetic.main.base_activity.*

class SummaryActivity : BaseActivity() {

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_summary,ll_body,true)
        btn_book.setOnClickListener {
            val intent = Intent(this,BookingConfirmationActivity::class.java)
            startActivity(intent)
        }

        btn_cancel.setOnClickListener {
            finish()
        }
    }
}