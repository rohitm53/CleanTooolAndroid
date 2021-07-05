package com.cleantool.indiacleantool.models.networkmodels.signup


data class SignUpResponse(
        val id: String,
        val firstName: String,
        val lastName: String,
        val dateOfBirth: String,
        val mobile: String,
        val email: String,
        val mobileUserCode: String,
        val created_at: String,
        val updated_at: String

/*{
    "id": 2,
    "firstName": "rajesh",
    "lastName": "chinnala",
    "dateOfBirth": "1992-07-01",
    "mobile": "9393417123",
    "email": "raj@gmail.com",
    "mobileUserCode": "mrajesh02",
    "created_at": "2021-07-03",
    "updated_at": "2021-07-03"
}*/
)