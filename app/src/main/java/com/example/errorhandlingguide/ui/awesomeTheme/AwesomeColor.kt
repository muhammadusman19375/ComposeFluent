package com.example.errorhandlingguide.ui.awesomeTheme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class AwesomeColor(
    primary: Color,
    onPrimary: Color,
    error: Color,
    onError: Color,
    success: Color,
    onSuccess: Color,
    warning: Color,
    onWarning: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    outline: Color,
    isLight: Boolean,
) {
    var primary by mutableStateOf(primary)
        private set

    var onPrimary by mutableStateOf(onPrimary)
        private set

    var error by mutableStateOf(error)
        private set

    var onError by mutableStateOf(onError)
        private set

    var success by mutableStateOf(success)
        private set

    var onSuccess by mutableStateOf(onSuccess)
        private set

    var warning by mutableStateOf(warning)
        private set

    var onWarning by mutableStateOf(onWarning)
        private set

    var background by mutableStateOf(background)
        private set

    var onBackground by mutableStateOf(onBackground)
        private set

    var surface by mutableStateOf(surface)
        private set

    var onSurface by mutableStateOf(onSurface)
        private set

    var outline by mutableStateOf(outline)
        private set

    var isLight by mutableStateOf(isLight)
        internal set

    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        error: Color = this.error,
        onError: Color = this.onError,
        success: Color = this.success,
        onSuccess: Color = this.onSuccess,
        warning: Color = this.warning,
        onWarning: Color = this.onWarning,
        background: Color = this.background,
        onBackground: Color = this.onBackground,
        surface: Color = this.surface,
        onSurface: Color = this.onSurface,
        outline: Color = this.outline,
        isLight: Boolean = this.isLight,
    ): AwesomeColor = AwesomeColor(
        primary,
        onPrimary,
        error,
        onError,
        success,
        onSuccess,
        warning,
        onWarning,
        background,
        onBackground,
        surface,
        onSurface,
        outline,
        isLight,
    )

    fun updateColors(other: AwesomeColor) {
        primary = other.primary
        onPrimary = other.onPrimary
        error = other.error
        onError = other.onError
        success = other.success
        onSuccess = other.onSuccess
        warning = other.warning
        onWarning = other.onWarning
        background = other.background
        onBackground = other.onBackground
        surface = other.surface
        onSurface = other.onSurface
        outline = other.outline
        isLight = other.isLight
    }
}

internal val LocalColor = staticCompositionLocalOf {
    AwesomeColor(
        primary = Color(0xFF3700B3),
        onPrimary = Color(0xFF6200EE),
        error = Color(0xFFCE5B5B),
        onError = Color(0xFFAC0E0E),
        success = Color(0xFF03DAC5),
        onSuccess = Color(0xFF018786),
        warning = Color(0xFF680068),
        onWarning = Color(0xFF9E529E),
        background = Color(0xFFC5E666),
        onBackground = Color(0xFFD6E6A7),
        surface = Color(0xFF58B6DC),
        onSurface = Color(0xFF9ED5EC),
        outline = Color(0xFF3A3025),
        isLight = true
    )
}