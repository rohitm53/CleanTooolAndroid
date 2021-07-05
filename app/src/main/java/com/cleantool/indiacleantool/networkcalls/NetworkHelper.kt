package com.cleantool.indiacleantool.networkcalls

import com.cleantool.indiacleantool.models.networkmodels.common.ErrorResponse
import com.cleantool.indiacleantool.models.networkmodels.commosn.NetworkResultWrapper
import com.squareup.moshi.Moshi
import retrofit2.HttpException
import java.io.IOException


suspend fun<T> safeApiCall(apiCall: suspend () -> T ) : NetworkResultWrapper<T> {
    return try{
        NetworkResultWrapper.Success(apiCall.invoke())
    }catch (throwable : Throwable){
        when(throwable) {

            is IOException -> NetworkResultWrapper.NetworkError

            is HttpException -> {
                val code = throwable.code()
                val errorResponse = convertErrorBody(throwable)
                NetworkResultWrapper.GenericError(code,errorResponse)
            }

            else -> {
                NetworkResultWrapper.GenericError(null,null)
            }
        }

    }
}

private fun convertErrorBody(throwable: HttpException) : ErrorResponse? {

    return try{

        throwable.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
            moshiAdapter.fromJson(it)
        }

    }catch (e:Exception){
        null
    }

}


