package com.example.kotlin.presentationnew

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonDetailsScreen(
    pokemonDetailsViewModel: PokemonDetailsViewModel = hiltViewModel()
) {
    val state = pokemonDetailsViewModel.state.value

    if (state.isNotBlank()){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "$state",
                style = MaterialTheme.typography.h1
            )
        }
    }
}
