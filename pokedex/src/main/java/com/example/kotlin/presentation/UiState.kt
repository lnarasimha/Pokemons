package com.example.kotlin.presentation

import java.lang.Exception

sealed class UiState<out T> {
    object Loading : UiState<Nothing>()

    data class Success<out T>(
        val data: T
    ) : UiState<T>()

    data class Failure(
        val exception: Throwable
    ) : UiState<Nothing>()
}
