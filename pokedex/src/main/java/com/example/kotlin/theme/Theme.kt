package com.example.kotlin.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

@SuppressLint("ConflictingOnColor")
val LightThemeColors = lightColors(
    primary = primaryLight,
    secondary = secondaryLight,
    background = backgroundLight,
    surface = surfaceLight,
    error = errorLight,
    onPrimary = onPrimaryLight,
    onSecondary = onSecondaryLight,
    onBackground = onBackgroundLight,
    onSurface = onSurfaceLight,
    onError = onErrorLight,
)

val DarkThemeColors = darkColors(
    primary = primaryDark,
    secondary = secondaryDark,
    background = backgroundDark,
    surface = surfaceDark,
    error = errorDark,
    onPrimary = onPrimaryDark,
    onSecondary = onSecondaryDark,
    onBackground = onBackgroundDark,
    onSurface = onSurfaceDark,
    onError = onErrorDark,
)

@Composable
fun PokemonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkThemeColors else LightThemeColors
    MaterialTheme(
        colors = colorScheme,
        typography = LightTypography,
        content = content
    )
}
