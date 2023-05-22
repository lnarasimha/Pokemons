package com.example.kotlin.hiltnew

import com.example.kotlin.datanew.mappers.PokemonDetailsMapper
import com.example.kotlin.datanew.mappers.PokemonResponseMapper
import com.example.kotlin.datanew.network.PokemonService
import com.example.kotlin.datanew.repository.PokemonRepositoryImpl
import com.example.kotlin.domainnew.repository.PokemonRepository
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
