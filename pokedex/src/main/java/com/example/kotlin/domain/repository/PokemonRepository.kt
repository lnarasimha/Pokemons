package com.example.kotlin.domain.repository

import androidx.paging.Pager
import com.example.kotlin.domain.models.Pokemon
import com.example.kotlin.domain.models.PokemonDetails
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    fun getPokemonPager(): Pager<Int, Pokemon>
    fun getPokemonDetails(pokemonName: String): Flow<PokemonDetails>
}
