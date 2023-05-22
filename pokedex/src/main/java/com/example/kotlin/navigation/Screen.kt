package com.example.kotlin.navigation

const val SCREEN_POKEMON_LIST = "pokemon_list_screen"
const val SCREEN_POKEMON_DETAIL = "pokemon_details_screen"

sealed class Screen(val route: String) {
    object PokemonList : Screen(SCREEN_POKEMON_LIST)
    object PokemonDetails : Screen(SCREEN_POKEMON_DETAIL)
}
