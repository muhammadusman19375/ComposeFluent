package com.example.errorhandlingguide.domain

import com.example.errorhandlingguide.domain.error.PasswordError

class UserDataValidator {

    fun validatePassword(password: String): Result<Unit, PasswordError> {
        if (password.length < 8) {
            return Result.Error(PasswordError.TOO_SHORT)
        }

        val hasUppercaseChar = password.any { it.isUpperCase() }
        if (!hasUppercaseChar) {
            return Result.Error(PasswordError.NO_UPPERCASE)
        }

        val hasDigit = password.any { it.isDigit() }
        if (!hasDigit) {
            return Result.Error(PasswordError.NO_DIGIT)
        }

        return Result.Success(Unit)
    }
}