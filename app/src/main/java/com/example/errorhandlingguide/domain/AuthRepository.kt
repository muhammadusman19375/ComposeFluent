package com.example.errorhandlingguide.domain

import com.example.errorhandlingguide.domain.error.DataError

interface AuthRepository {

    suspend fun register(password: String): Result<User, DataError.Network>

}

data class User(
    val name: String,
    val token: String,
    val email: String
)