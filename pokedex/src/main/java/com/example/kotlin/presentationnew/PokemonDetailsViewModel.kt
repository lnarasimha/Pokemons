package com.example.kotlin.presentationnew

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf("")
    val state: State<String> = _state

    init {

        savedStateHandle.get<String>("pokemonName")?.let {
            _state.value = it
        }
    }
}
