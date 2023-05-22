package com.example.kotlin.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Spacing(
    val none: Dp = 0.dp,
    val extraSmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp,
    val extraLarge: Dp = 32.dp,
    val textExtraSmall: TextUnit = 12.sp,
    val textSmall: TextUnit = 14.sp,
    val textMedium: TextUnit = 16.sp,
    val textLarge: TextUnit = 24.sp
)

val LocalSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.Spacing: Spacing
    @Composable
    @ReadOnlyComposable
    get() = LocalSpacing.current
