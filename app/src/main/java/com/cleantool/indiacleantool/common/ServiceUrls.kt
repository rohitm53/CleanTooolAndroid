package com.cleantool.indiacleantool.common

object ServiceUrls {


    //Local : http://localhost:8080/api/users/authenticate

    const val BASE_URL = "http://192.168.1.103:8080"

    const val Login_Endpoint="api/users/authenticate"

    const val COMMON_URL="api/mobile/"


    ///After login Rest endpoint

    const val ServiceProviderUrl="api/mobile/servicedetails/{service_code}"
    const val BookServiceUrl = "api/servicerequest/book"
    const val GetAllMobileUserServiceRequest = "api/servicerequest/mobile"


}