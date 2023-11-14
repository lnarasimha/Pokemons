package com.example.kotlin.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.domain.models.PokemonDetails
import com.example.kotlin.domain.usecase.GetPokemonDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
) : ViewModel() {

    private val _state = mutableStateOf<UiState<PokemonDetails>>(UiState.Loading)
    val state: State<UiState<PokemonDetails>> = _state

    init {
        savedStateHandle.get<String>("pokemonName")?.let { pokemonName ->
            viewModelScope.launch {
                getPokemonDetailsUseCase.getPokemonDetails(pokemonName = pokemonName)
                    .onEach {
                        _state.value = UiState.Success(it)
                    }
                    .catch {
                        _state.value = UiState.Failure(it)
                    }
                    .launchIn(viewModelScope)

            }
        }
    }
}
