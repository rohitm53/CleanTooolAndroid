package com.cleantool.indiacleantool.appmodules.commonmodule

import android.animation.ObjectAnimator
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cleantool.indiacleantool.R
import kotlinx.android.synthetic.main.base_activity.*
import kotlinx.android.synthetic.main.toolbar_common_header.*
import kotlinx.android.synthetic.main.toolbar_common_header.toolbar

abstract class BaseActivity : AppCompatActivity() {

    abstract fun initialize()

    private lateinit var progressDialog :Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        initialiseHeader()
        initialize()
    }

    private fun initialiseHeader(){
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        btn_back.setOnClickListener { finish() }
    }


    fun showLoader(message: String){
        hideLoader()
        this.runOnUiThread(ShowLoaderRunnable(this,message))
    }

    fun hideLoader(){
        this.runOnUiThread {
            if(this::progressDialog.isInitialized && progressDialog.isShowing){
                progressDialog.cancel()
            }
        }
    }

    fun showAlert(msg:String,
                  positiveAction:DialogInterface.OnClickListener,
                  negativeAction:DialogInterface.OnClickListener  ){

        this.runOnUiThread {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Alert! ")
            builder.setIcon(R.drawable.dialog_error_icon)
            builder.setMessage(msg)

            builder.setPositiveButton(Html.fromHtml("<font color=#CE0000>${getString(R.string.ok)}</font>"),positiveAction)
            builder.setNegativeButton(Html.fromHtml("<font color=#CE0000>${getString(R.string.cancel)}</font>"),negativeAction)


            val alertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }


    inner class ShowLoaderRunnable(private var context: Context,private val message: String) : Runnable{

        override fun run() {
            progressDialog = Dialog(context,R.style.Theme_Dialog_Translucent)
            progressDialog.setContentView(R.layout.progress_dialog)

            val iv_loading : ImageView = progressDialog.findViewById(R.id.iv_loading)
            val iv_internal_image : ImageView = progressDialog.findViewById(R.id.iv_internal_image)
            val tv_msg : TextView = progressDialog.findViewById(R.id.tv_msg)
            val rotateXaxis  : Animation =AnimationUtils.loadAnimation(context,R.anim.rotate_x_axis)
            rotateXaxis.setInterpolator(LinearInterpolator())
            iv_loading.animation=rotateXaxis



            if(TextUtils.isEmpty(message)){
                tv_msg.visibility=View.GONE
            }else{
                tv_msg.text=message
                tv_msg.visibility=View.VISIBLE
            }
            val animationYaxis = ObjectAnimator.ofFloat(iv_internal_image,"rotationY",0.0f,360f);
            animationYaxis.setDuration(1000)
            animationYaxis.repeatCount= ObjectAnimator.INFINITE
            animationYaxis.setInterpolator(LinearInterpolator())
            animationYaxis.start()

            progressDialog.setCancelable(false)
            progressDialog.show()
        }
    }

    fun hideToolbar(){
        toolbar.visibility=View.GONE
    }
    fun showToolbar(){
        toolbar.visibility=View.VISIBLE
    }

    fun showToast(message: String) {
        Toast.makeText(this, "" + message, Toast.LENGTH_SHORT).show()
    }

}