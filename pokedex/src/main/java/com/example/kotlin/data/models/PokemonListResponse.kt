package com.example.kotlin.data.models

data class PokemonListResponse(
    val count: String,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResponse>
)

data class PokemonResponse(
    val name: String,
    val url: String,
) {
    val imageUrl: String
        get() = getImageUrlFromUrl()

    private fun getImageUrlFromUrl(): String {
        val index = url.split("/".toRegex()).dropLast(1).last()
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
    }
}

data class PokemonDetailsResponse(
    val name: String,
    val height: Int,
    val weight: Int,
    val experience: Int,
)
