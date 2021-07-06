package com.cleantool.indiacleantool.models.networkmodels.common

sealed class NetworkResultWrapper<out T> {

    data class Success<out T>(val value : T) : NetworkResultWrapper<T>()
    data class GenericError(val errorCode : Int?=null,val error : ErrorResponse? = null) : NetworkResultWrapper<Nothing>()
    object NetworkError : NetworkResultWrapper<Nothing>()

}