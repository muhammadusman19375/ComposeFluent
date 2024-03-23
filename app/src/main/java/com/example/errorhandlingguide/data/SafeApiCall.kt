package com.example.errorhandlingguide.data

import android.util.Log
import com.example.errorhandlingguide.domain.Result
import com.example.errorhandlingguide.domain.error.DataError
import retrofit2.HttpException
import java.io.IOException

suspend fun <D> safeApiCall(
    apiCall: suspend () -> D
): Result<D, DataError.Network> {
    return try {
        val response = apiCall.invoke()
        Log.d("SafeApiCall", "Result.Success -> response: $response")
        Result.Success(response)
    } catch (e: HttpException) {
        Log.d("SafeApiCall", "Result.Error -> HttpException error code: ${e.code()}")
        when (e.code()) {
            408 -> Result.Error(DataError.Network.REQUEST_TIMEOUT)
            413 -> Result.Error(DataError.Network.PAYLOAD_TOO_LARGE)
            429 -> Result.Error(DataError.Network.TOO_MANY_REQUESTS)
            500 -> Result.Error(DataError.Network.SERVER_ERROR)
            else -> Result.Error(DataError.Network.UNKNOWN)
        }
    } catch (e: IOException) {
        Log.d("SafeApiCall", "Result.Error -> IOException no internet available")
        Result.Error(DataError.Network.NO_INTERNET)
    }
}