package com.example.kotlin.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kotlin.data.mappers.PokemonDetailsMapper
import com.example.kotlin.data.mappers.PokemonResponseMapper
import com.example.kotlin.data.network.PokemonPagingSource
import com.example.kotlin.data.network.PokemonService
import com.example.kotlin.domain.models.Pokemon
import com.example.kotlin.domain.models.PokemonDetails
import com.example.kotlin.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonService: PokemonService,
    private val pokemonResponseMapper: PokemonResponseMapper,
    private val pokemonDetailsMapper: PokemonDetailsMapper
) : PokemonRepository {

    override fun getPokemonPager(): Pager<Int, Pokemon> {
        return Pager(
            PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = {
                PokemonPagingSource(
                    pokemonService,
                    pokemonResponseMapper,
                    pokemonDetailsMapper
                )
            }
        )
    }

    override fun getPokemonDetails(pokemonName: String): Flow<PokemonDetails> = flow {
        emit(pokemonDetailsMapper.toDomain(pokemonService.pokemonDetails(pokemonName).body()!!))
    }
}
