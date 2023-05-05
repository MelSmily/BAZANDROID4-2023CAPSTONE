package com.jlhg.wizeline.capstoneproject.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    background = Black,
    primary = GreenLight,
    primaryVariant = Green,
    secondary = Grey,
    secondaryVariant = GreyLight,
    error = Red,
)

@Composable
fun MoviesTheme(content: @Composable () -> Unit) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}
