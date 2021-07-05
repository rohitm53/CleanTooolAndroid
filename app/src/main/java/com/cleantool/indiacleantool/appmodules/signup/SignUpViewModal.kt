package com.cleantool.indiacleantool.appmodules.signup

import android.util.Log.d
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cleantool.indiacleantool.appmodules.signup.service.SignUpRepository
import com.cleantool.indiacleantool.common.Preference
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.commosn.NetworkResultWrapper
import com.cleantool.indiacleantool.models.networkmodels.signup.SignUpRequest
import kotlinx.coroutines.launch
import javax.inject.Inject


class SignUpViewModal : ViewModel() {


    @Inject
    lateinit var signupRepository: SignUpRepository
    @Inject
    lateinit var preference: Preference

    var signUpRequest = SignUpRequest("rajesh", "chinnala", "1991-09-02", "9393417123", "rajesh@gmail.com", "hyd")


    val liveDataSignUpStatus = MutableLiveData<SignUpStatus>()

    init {
        ServiceIndiaApplication.getApplicationComponent().inject(this)
    }

    fun register() {

        viewModelScope.launch {
            liveDataSignUpStatus.postValue(SignUpStatus(SHOW_LOADER, "Sign Up.."))
            val networkResponse = signupRepository.registerUser(signUpRequest)
            when (networkResponse) {
                is NetworkResultWrapper.Success -> {
                    val signupResponse = networkResponse.value
                    if (!signupResponse.mobileUserCode.isEmpty()) {
                        preference.saveString(Preference.Keys.UserCode, signupResponse.mobileUserCode)
                        preference.saveString(Preference.Keys.Password,"password")
                        liveDataSignUpStatus.postValue(SignUpStatus(HIDE_LOADER, null))
                        liveDataSignUpStatus.postValue(SignUpStatus(SUCCESS, signupResponse))
                    }
                }

                is NetworkResultWrapper.NetworkError -> {
                    d("rohitclean", "Network Error")
                    liveDataSignUpStatus.postValue(SignUpStatus(HIDE_LOADER, null))
                    liveDataSignUpStatus.postValue(SignUpStatus(ERROR, "Error while loggin in"))
                }

                is NetworkResultWrapper.GenericError -> {
                    d("rohitclean", "Generic Error : ${networkResponse}")
                    liveDataSignUpStatus.postValue(SignUpStatus(HIDE_LOADER, null))
                    liveDataSignUpStatus.postValue(SignUpStatus(ERROR, "Error while loggin in"))
                }
            }
        }
    }

    //  Status Management
    data class SignUpStatus(val status: Int, val data: Any?)

    companion object {
        val SUCCESS = 1
        val ERROR = 2
        val SHOW_LOADER = 3
        val HIDE_LOADER = 4
        val SHOW_TOAST = 5
        val NAVIGATE_TO_SIGNUP = 6
    }

}