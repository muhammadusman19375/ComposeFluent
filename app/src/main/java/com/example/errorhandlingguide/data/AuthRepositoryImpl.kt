package com.example.errorhandlingguide.data

import com.example.errorhandlingguide.domain.AuthRepository
import com.example.errorhandlingguide.domain.Result
import com.example.errorhandlingguide.domain.User
import com.example.errorhandlingguide.domain.error.DataError
import kotlinx.coroutines.delay

class AuthRepositoryImpl : AuthRepository {
    override suspend fun register(password: String): Result<User, DataError.Network> {
        return safeApiCall {
            fetchUserData(password)
        }
    }
}


/**
 * This can be dao or api interface.
 */
suspend fun fetchUserData(password: String): User {
    delay(2000)
    return User("Usman", password, "usman@gmail.com")
}