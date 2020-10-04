package com.cleantool.indiacleantool.appmodules.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleantool.indiacleantool.appmodules.login.repository.LoginRepository
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.login.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModal : ViewModel() {

    init {
        ServiceIndiaApplication.getApplicationComponent().inject(this)
    }

    @Inject lateinit var loginRepository: LoginRepository

    companion object{
        enum class Status {
            SUCCESS,
            ERROR
        }
    }

    val liveDataStatus = MutableLiveData<Status>()


    fun authenticateUser(username:String,password:String){
        val loginRequest = LoginRequest(username,password)
        viewModelScope.launch(Dispatchers.Default) {
            val loginResponse = loginRepository.authenticatUser(loginRequest)
            if(!loginResponse.jwt.isEmpty()){
                liveDataStatus.postValue(Status.SUCCESS)
            }else{
                liveDataStatus.postValue(Status.ERROR)
            }
        }
    }




}