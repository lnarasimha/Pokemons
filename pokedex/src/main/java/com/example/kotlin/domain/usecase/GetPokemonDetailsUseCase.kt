package com.example.kotlin.domain.usecase

import com.example.kotlin.domain.models.PokemonDetails
import kotlinx.coroutines.flow.Flow

interface GetPokemonDetailsUseCase {
    fun getPokemonDetails(pokemonName: String): Flow<PokemonDetails>
}
