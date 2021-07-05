package com.cleantool.indiacleantool.appmodules.signup.service

import com.cleantool.indiacleantool.common.ServiceUrls
import com.cleantool.indiacleantool.models.networkmodels.signup.SignUpRequest
import com.cleantool.indiacleantool.models.networkmodels.signup.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST


//http://localhost:8080/api/users/authenticate

interface SignUpService {

    @POST(ServiceUrls.SignUp_Endpoint)
    suspend fun registerUser(@Body signUpRequest: SignUpRequest) : SignUpResponse


}