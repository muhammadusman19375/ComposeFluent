package com.example.errorhandlingguide.ui.awesomeTheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.errorhandlingguide.R

class AwesomeTypography {
    val h1: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 38.sp,
        )
    val h2: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
        )
    val h3: TextStyle
        @Composable
        get() = TextStyle(
            fontFamily = FontFamily(Font(R.font.roboto_medium)),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 30.sp,
        )
}

internal val LocalTypography = staticCompositionLocalOf { AwesomeTypography() }