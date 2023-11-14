package com.example.kotlin.hilt

import com.example.kotlin.data.mappers.PokemonDetailsMapper
import com.example.kotlin.data.mappers.PokemonResponseMapper
import com.example.kotlin.data.network.PokemonService
import com.example.kotlin.data.repository.PokemonRepositoryImpl
import com.example.kotlin.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePokemonRepository(
        pokemonService: PokemonService,
        pokemonResponseMapper: PokemonResponseMapper,
        pokemonDetailsMapper: PokemonDetailsMapper

    ): PokemonRepository {
        return PokemonRepositoryImpl(
            pokemonService, pokemonResponseMapper, pokemonDetailsMapper
        )
    }
}
