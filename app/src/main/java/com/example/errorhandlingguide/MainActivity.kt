package com.example.errorhandlingguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.errorhandlingguide.data.AuthRepositoryImpl
import com.example.errorhandlingguide.domain.AuthRepository
import com.example.errorhandlingguide.domain.UserDataValidator
import com.example.errorhandlingguide.presentation.UserViewModel
import com.example.errorhandlingguide.ui.awesomeTheme.AwesomeTheme

class MainActivity : ComponentActivity() {
    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory(
            UserDataValidator(), AuthRepositoryImpl()
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AwesomeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = AwesomeTheme.colors.outline
                ) {
                    LaunchedEffect(key1 = true) {
                        userViewModel.onRegisterClick("Usman12345")
                    }
                    val state = userViewModel.state.collectAsStateWithLifecycle()

                    /**
                     * Get error message from state like this way.
                     */

                    /**
                     * Get error message from state like this way.
                     */
                    state.value.error?.asString()

                    /**
                     * Get data from state like this way
                     */

                    /**
                     * Get data from state like this way
                     */
                    state.value.data?.let { user ->
                        HomeScreen(value = user.token)
                    }
                }
            }
        }
    }
}

@Composable
fun HomeScreen(value: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AwesomeTheme.colors.outline), contentAlignment = Alignment.Center
    ) {
        Column {
            Image(imageVector = AwesomeTheme.icons.direction, contentDescription = "")
            Text(
                text = value, style = AwesomeTheme.typography.h3
            )
        }
    }
}

class UserViewModelFactory(
    private val userDataValidator: UserDataValidator,
    private val authRepository: AuthRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return UserViewModel(userDataValidator, authRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
