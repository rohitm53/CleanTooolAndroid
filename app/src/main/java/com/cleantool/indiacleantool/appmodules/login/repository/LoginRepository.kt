package com.cleantool.indiacleantool.appmodules.login.repository

import com.cleantool.indiacleantool.appmodules.login.service.LoginService
import com.cleantool.indiacleantool.common.ServiceIndiaApplication
import com.cleantool.indiacleantool.models.networkmodels.login.LoginRequest
import com.cleantool.indiacleantool.models.networkmodels.login.LoginResponse
import javax.inject.Inject


class LoginRepository() {


    init {
        ServiceIndiaApplication.getApplicationComponent().inject(this)
    }

    @Inject
    lateinit var loginService : LoginService


    suspend fun authenticatUser(loginRequest: LoginRequest): LoginResponse {
        return loginService.authenticateUser(loginRequest)
    }

}