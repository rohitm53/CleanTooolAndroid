package com.cleantool.indiacleantool.appmodules.splashscreen

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Handler
import androidx.core.app.ActivityCompat
import com.cleantool.indiacleantool.R
import com.cleantool.indiacleantool.appmodules.commonmodule.BaseActivity
import com.cleantool.indiacleantool.appmodules.login.LoginActivity
import kotlinx.android.synthetic.main.base_activity.*

class SplashScreenActivity : BaseActivity() {

    val PERMISSION_REQUEST_CODE  = 100

    override fun initialize() {
        layoutInflater.inflate(R.layout.activity_splash_screen,ll_body,true)
        hideToolbar()
        showLoader("Initialising...")
        checkReqPermission()
    }

    @SuppressLint("NewApi")
    private fun checkReqPermission(){
        if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            showLoader("Initialising...")
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),PERMISSION_REQUEST_CODE)
        }else{
            navigateToLogin()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        var permissionStatus=true
        when(requestCode){
            PERMISSION_REQUEST_CODE -> {
                for(item in grantResults){
                    if(item!=PackageManager.PERMISSION_GRANTED){
                        permissionStatus=false
                        break
                    }
                }
            }
        }
        if(permissionStatus){
            navigateToLogin()
        }else{
            showToast("Permission denied")
            finish()
        }
    }

    private fun navigateToLogin(){
        showLoader("Initialising...")
        Handler().postDelayed({
            hideLoader()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },1000)
    }


}