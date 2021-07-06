package com.cleantool.indiacleantool.appmodules.signup.repository

import com.cleantool.indiacleantool.appmodules.signup.service.SignUpService
import com.cleantool.indiacleantool.models.networkmodels.common.NetworkResultWrapper
import com.cleantool.indiacleantool.models.networkmodels.signup.SignUpRequest
import com.cleantool.indiacleantool.models.networkmodels.signup.SignUpResponse
import com.cleantool.indiacleantool.networkcalls.safeApiCall
import javax.inject.Inject


//http://localhost:8080/api/users/authenticate

class SignUpRepository @Inject constructor(var signUpService: SignUpService) {

    suspend fun registerUser(signUpRequest: SignUpRequest): NetworkResultWrapper<SignUpResponse> {
        return safeApiCall { signUpService.registerUser(signUpRequest) }
    }

}