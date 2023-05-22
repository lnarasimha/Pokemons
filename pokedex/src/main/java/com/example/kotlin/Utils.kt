package com.example.kotlin

import android.net.Uri
import com.example.kotlin.data.PokemonListRepository

fun getPageFromUrl(urlString: String?): Int? {
    return urlString?.let {
        Uri.parse(it).getQueryParameter("offset")?.toInt()?.div(
            PokemonListRepository.PER_PAGE
        )
    }
}

fun getImageUrlFromUrl(urlString: String?): String {
    if (urlString.isNullOrEmpty()) return ""
    val index = urlString.split("/".toRegex()).dropLast(1).last()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
}
