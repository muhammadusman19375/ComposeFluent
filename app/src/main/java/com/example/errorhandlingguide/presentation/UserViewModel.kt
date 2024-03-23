package com.example.errorhandlingguide.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.errorhandlingguide.domain.AuthRepository
import com.example.errorhandlingguide.domain.Result
import com.example.errorhandlingguide.domain.User
import com.example.errorhandlingguide.domain.UserDataValidator
import com.example.errorhandlingguide.domain.error.PasswordError
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserViewModel(
    private val userDataValidator: UserDataValidator,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UserVmState())
    val state: StateFlow<UserVmState> = _state.asStateFlow()

    fun onRegisterClick(password: String) {
        when (val result = userDataValidator.validatePassword(password)) {
            is Result.Error -> {
                when (result.error) {
                    PasswordError.TOO_SHORT -> TODO()
                    PasswordError.NO_UPPERCASE -> TODO()
                    PasswordError.NO_DIGIT -> TODO()
                }
            }

            is Result.Success -> {
                register(password)
            }
        }
    }

    private fun register(password: String) {
        viewModelScope.launch {
            when (val result = authRepository.register(password)) {
                is Result.Success -> {
                    _state.update { state ->
                        state.copy(
                            data = result.data
                        )
                    }
                }

                is Result.Error -> {
                    _state.update { state ->
                        state.copy(
                            error = result.error.asUiText()
                        )
                    }
                }
            }
        }
    }
}

data class UserVmState(
    val error: UiText? = null,
    val data: User? = null
)