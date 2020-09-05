package com.cleantool.indiacleantool.appmodules.signup

import android.app.DatePickerDialog
import android.view.View
import android.widget.DatePicker
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.utils.dateutils.CalendarUtils
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.base_activity.*
import java.util.*

class SignUpActivity : BaseActivity() {

    private var calendar = Calendar.getInstance()
    private lateinit var  dateSetListner : DatePickerDialog.OnDateSetListener

    override fun initialize() {
        hideToolbar()
        layoutInflater.inflate(R.layout.activity_sign_up,ll_body,true)
         dateSetListner = object : DatePickerDialog.OnDateSetListener{
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dateOfMonth: Int) {
                setDateOfBirth(year,month,dateOfMonth)
            }
        }

        tv_dob.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                showDatePickerDialog()
            }
        })
    }

    private fun showDatePickerDialog(){

        DatePickerDialog(this,dateSetListner,
                                                    calendar.get(Calendar.YEAR),
                                                    calendar.get(Calendar.MONTH),
                                                    calendar.get(Calendar.DAY_OF_MONTH)).show()

    }

    private fun setDateOfBirth(year: Int, month: Int, dateOfMonth: Int) {
        calendar.set(Calendar.YEAR,year)
        calendar.set(Calendar.MONTH,month)
        calendar.set(Calendar.DAY_OF_MONTH,dateOfMonth)
        val actualMonth = month+1
        var strDate=""
        if(dateOfMonth<10){
            strDate = ""+year+"-0"+actualMonth+"-"+"0"+dateOfMonth
        }else{
            strDate = ""+year+"-0"+actualMonth+"-"+dateOfMonth
        }

        tv_dob.text = CalendarUtils.getDateInStandFormat(strDate);

    }

}