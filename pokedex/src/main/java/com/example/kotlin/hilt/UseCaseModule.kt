package com.example.kotlin.hilt

import com.example.kotlin.domain.repository.PokemonRepository
import com.example.kotlin.domain.usecase.GetPokemonDetailsUseCase
import com.example.kotlin.domain.usecase.GetPokemonDetailsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetPokemonDetailsUseCase(
        pokemonRepository: PokemonRepository,
        dispatcher: CoroutineDispatcher
    ): GetPokemonDetailsUseCase {
        return GetPokemonDetailsUseCaseImpl(pokemonRepository, dispatcher)
    }
}
