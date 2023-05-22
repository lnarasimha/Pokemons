package com.example.kotlin.presentationnew

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kotlin.R
import com.example.kotlin.domainnew.models.Pokemon
import com.example.kotlin.theme.Spacing

@Composable
fun PokemonListScreen(
    pokemonListViewModel: PokemonListViewModel = hiltViewModel(),
    navigateToDetailsScreen: (name: String) -> Unit
) {
    val pokemonList = pokemonListViewModel.pokemonListFlow.collectAsLazyPagingItems()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        contentAlignment = Alignment.Center,
    ) {

        if (pokemonList.loadState.refresh == LoadState.Loading) {
            CircularProgressIndicator()
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(all = 16.dp)
        ) {
            items(pokemonList.itemCount) { index ->
                val pokemon = pokemonList[index]
                if (pokemon != null) {
                    PokemonItem(
                        pokemon = pokemon,
                        navigateToDetailsScreen
                    )
                }
            }

            if (pokemonList.loadState.append == LoadState.Loading) {
                item {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonItem(
    pokemon: Pokemon,
    navigateToDetailsScreen: (name: String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        elevation = 6.dp,
        shape = RoundedCornerShape(MaterialTheme.Spacing.medium),
        onClick = { navigateToDetailsScreen.invoke(pokemon.name) }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.Spacing.medium),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = pokemon.name)
            AsyncImage(
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(MaterialTheme.Spacing.medium)),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.imageUrl)
                    .build(),
                contentDescription = "Image",
                contentScale = ContentScale.Fit,
                placeholder = painterResource(id = R.drawable.ic_launcher_background)
            )
            if (pokemon.pokemonDetails != null) {
                Text(text = pokemon.pokemonDetails?.height!!.toString())
            }
        }
    }
}
