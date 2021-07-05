package com.cleantool.indiacleantool.common

object ServiceUrls {


    //Local : http://localhost:8080/api/users/authenticate
//http://test1cleanservice-env.eba-yhqmgaep.ap-south-1.elasticbeanstalk.com/api/users/mobile-user
    const val BASE_URL = "http://test1cleanservice-env.eba-yhqmgaep.ap-south-1.elasticbeanstalk.com/"

    const val Login_Endpoint="api/users/authenticate"
    const val SignUp_Endpoint="api/users/mobile-user"

    const val COMMON_URL="api/mobile/"


    ///After login Rest endpoint

    const val ServiceProviderUrl="api/mobile/servicedetails/{service_code}"
    const val BookServiceUrl = "api/servicerequest/book"
    const val GetAllMobileUserServiceRequest = "api/servicerequest/mobile"
    const val UserRegistration = "/api/users/mobile-user"


}