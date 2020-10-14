package com.cleantool.indiacleantool.models.networkmodels.commosn

import com.cleantool.indiacleantool.models.networkmodels.common.ErrorResponse

sealed class NetworkResultWrapper<out T> {

    data class Success<out T>(val value : T) : NetworkResultWrapper<T>()
    data class GenericError(val errorCode : Int?=null,val error : ErrorResponse? = null) : NetworkResultWrapper<Nothing>()
    object NetworkError : NetworkResultWrapper<Nothing>()

}