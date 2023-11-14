package com.example.kotlin.domain.models

data class Pokemon(
    val name: String,
    val url: String,
    val imageUrl: String,
    var pokemonDetails: PokemonDetails? = null
)

data class PokemonDetails(
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
)
