package com.cleantool.indiacleantool.appmodules.login.service

import com.cleantool.indiacleantool.common.ServiceUrls
import com.cleantool.indiacleantool.models.networkmodels.login.LoginRequest
import com.cleantool.indiacleantool.models.networkmodels.login.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST


//http://localhost:8080/api/users/authenticate

interface LoginService {

    @POST(ServiceUrls.Login_Endpoint)
    suspend fun authenticateUser(@Body loginRequest: LoginRequest) : LoginResponse


}