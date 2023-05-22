package com.example.kotlin.datanew.network

import com.example.kotlin.datanew.models.PokemonDetailsResponse
import com.example.kotlin.datanew.models.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    suspend fun pokemonList(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int = 20
    ): Response<PokemonListResponse>

    @GET("pokemon/{pokemonName}")
    suspend fun pokemonDetails(
        @Path("pokemonName") pokemonName: String
    ): Response<PokemonDetailsResponse>
}
