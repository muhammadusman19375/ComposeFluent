package com.example.errorhandlingguide.ui.awesomeTheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.errorhandlingguide.R

class AwesomeIcon {

    val direction: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground)

    val feedback: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground)

    val coin: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_launcher_background)

    val play: ImageVector
        @Composable
        get() = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground)
}

internal val LocaleIcon = staticCompositionLocalOf { AwesomeIcon() }