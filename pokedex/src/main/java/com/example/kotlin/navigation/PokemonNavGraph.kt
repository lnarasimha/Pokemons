package com.example.kotlin.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.kotlin.presentationnew.PokemonDetailsScreen
import com.example.kotlin.presentationnew.PokemonListScreen

@Composable
fun PokemonNavGraph(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = Screen.PokemonList.route
    ) {

        composable(route = Screen.PokemonList.route) {
            PokemonListScreen(
                navigateToDetailsScreen = {
                    navController.navigate("${Screen.PokemonDetails.route}/$it")
                }
            )
        }

        composable(
            route = "${Screen.PokemonDetails.route}/{pokemonName}",
            arguments = listOf(navArgument("pokemonName") {
                type = NavType.StringType
            })
        ) {
            PokemonDetailsScreen()
        }
    }
}
