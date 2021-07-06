package com.cleantool.indiacleantool.appmodules.login

import android.util.Log
import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleantool.indiacleantool.appmodules.login.repository.LoginRepository
import com.cleantool.indiacleantool.common.Preference
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.common.NetworkResultWrapper
import com.cleantool.indiacleantool.models.networkmodels.login.LoginRequest
import kotlinx.coroutines.launch
import javax.inject.Inject


class LoginViewModal : ViewModel() {


    @Inject lateinit var loginRepository: LoginRepository
    @Inject lateinit var preference: Preference

    var loginRequest = LoginRequest("mrohit01","password")


    val liveDataStatus =MutableLiveData<LoginStatus>()

    init {
        ServiceIndiaApplication.getApplicationComponent().inject(this)
    }

    fun authenticateUser(){

        viewModelScope.launch {
            liveDataStatus.postValue(LoginStatus(SHOW_LOADER,"Logging in"))
            when(val networkResponse = loginRepository.authenticateUser(loginRequest)){
                is NetworkResultWrapper.Success -> {
                    val loginResponse = networkResponse.value
                    if(loginResponse.jwt.isNotEmpty()){
                        preference.saveString(Preference.Keys.UserCode,loginRequest.username)
                        preference.saveString(Preference.Keys.JsonWebToken,loginResponse.jwt)
                        liveDataStatus.postValue(LoginStatus(HIDE_LOADER,null))
                        liveDataStatus.postValue(LoginStatus(SUCCESS,loginResponse.jwt))
                    }
                }

                is NetworkResultWrapper.NetworkError -> {
                    liveDataStatus.postValue(LoginStatus(HIDE_LOADER,null))
                    liveDataStatus.postValue(LoginStatus(ERROR,"Error while logging in"))
                }

                is NetworkResultWrapper.GenericError -> {
                    liveDataStatus.postValue(LoginStatus(HIDE_LOADER,null))
                    liveDataStatus.postValue(LoginStatus(ERROR,"Error while loggin in"))
                }
            }
        }
    }

    fun navigateToSignup(){
        liveDataStatus.postValue(LoginStatus(NAVIGATE_TO_SIGNUP,null))
    }

    //  Status Management
    data class LoginStatus (val status: Int,val data: Any? )

    companion object  {
        val SUCCESS = 1
        val ERROR = 2
        val SHOW_LOADER = 3
        val HIDE_LOADER = 4
        val SHOW_TOAST=5
        val NAVIGATE_TO_SIGNUP=6
    }

}