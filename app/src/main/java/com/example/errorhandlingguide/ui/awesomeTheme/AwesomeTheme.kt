package com.example.errorhandlingguide.ui.awesomeTheme

import androidx.compose.foundation.LocalIndication
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

object AwesomeTheme {
    val colors: AwesomeColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColor.current

    val typography: AwesomeTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val dimensions: AwesomeDimension
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current

    val icons: AwesomeIcon
        @Composable
        @ReadOnlyComposable
        get() = LocaleIcon.current
}

@Composable
fun AwesomeTheme(
    colors: AwesomeColor = AwesomeTheme.colors,
    typography: AwesomeTypography = AwesomeTheme.typography,
    dimensions: AwesomeDimension = AwesomeTheme.dimensions,
    icons: AwesomeIcon = AwesomeTheme.icons,
    content: @Composable () -> Unit,
) {
    val rememberedColors = remember { colors.copy() }.apply { updateColors(colors) }
    CompositionLocalProvider(
        LocalColor provides rememberedColors,
        LocalDimensions provides dimensions,
        LocalTypography provides typography,
        LocaleIcon provides icons,
        LocalIndication provides rememberRipple(),
    ) {
        content()
    }
}