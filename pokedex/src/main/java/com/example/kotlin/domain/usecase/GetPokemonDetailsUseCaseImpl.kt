package com.example.kotlin.domain.usecase

import com.example.kotlin.domain.models.PokemonDetails
import com.example.kotlin.domain.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPokemonDetailsUseCaseImpl @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val dispatcher: CoroutineDispatcher
) : GetPokemonDetailsUseCase {
    override fun getPokemonDetails(pokemonName: String): Flow<PokemonDetails> =
        pokemonRepository.getPokemonDetails(pokemonName).flowOn(dispatcher)
}
