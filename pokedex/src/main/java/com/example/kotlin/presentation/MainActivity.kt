package com.example.kotlin.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.kotlin.R
import com.example.kotlin.navigation.PokemonNavGraph
import com.example.kotlin.theme.PokemonTheme
import com.example.kotlin.theme.Spacing
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PokemonTheme {
                navController = rememberNavController()
                Scaffold(
                    topBar = {
                        PokemonToolBar()
                    },
                    content = {
                        PokemonNavGraph(navController = navController)
                    }
                )
            }
        }
    }
}

@Composable
fun PokemonToolBar() {
    TopAppBar(
        elevation = MaterialTheme.Spacing.small,
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Pokemon", modifier = Modifier.padding(MaterialTheme.Spacing.extraSmall))
            IconButton(onClick = {  }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_search_24),
                    contentDescription = stringResource(R.string.search)
                )
            }
        }
    }
}
