package com.example.kotlin.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.kotlin.domain.models.PokemonDetails

@Composable
fun PokemonDetailsScreen(
    pokemonDetailsViewModel: PokemonDetailsViewModel = hiltViewModel(),
    pokemonName: String
) {
    val state = pokemonDetailsViewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is UiState.Loading -> {
                CircularProgressIndicator()
            }

            is UiState.Success -> {
                Details(pokemonDetails = state.data)
            }

            is UiState.Failure -> {
                Text(text = state.exception.localizedMessage ?: "Error")
            }
        }
    }
}

@Composable
fun Details(
    pokemonDetails: PokemonDetails
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(text = pokemonDetails.name)
            Text(text = pokemonDetails.height.toString())
            Text(text = pokemonDetails.weight.toString())
            Text(text = pokemonDetails.experience.toString())
        }
    }
}
