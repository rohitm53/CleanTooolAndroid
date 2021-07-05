package com.cleantool.indiacleantool.appmodules.login.repository

import com.cleantool.indiacleantool.appmodules.login.service.LoginService
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.commosn.NetworkResultWrapper
import com.cleantool.indiacleantool.models.networkmodels.login.LoginRequest
import com.cleantool.indiacleantool.models.networkmodels.login.LoginResponse
import com.cleantool.indiacleantool.networkcalls.safeApiCall
import javax.inject.Inject


class LoginRepository @Inject constructor( var loginService : LoginService) {

    suspend fun authenticateUser(loginRequest: LoginRequest): NetworkResultWrapper<LoginResponse> {
        return safeApiCall { loginService.authenticateUser(loginRequest) }
    }

}