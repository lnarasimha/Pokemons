package com.example.kotlin.datanew.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kotlin.datanew.mappers.PokemonDetailsMapper
import com.example.kotlin.datanew.mappers.PokemonResponseMapper
import com.example.kotlin.datanew.network.PokemonPagingSource
import com.example.kotlin.datanew.network.PokemonService
import com.example.kotlin.domainnew.models.Pokemon
import com.example.kotlin.domainnew.repository.PokemonRepository
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
}
