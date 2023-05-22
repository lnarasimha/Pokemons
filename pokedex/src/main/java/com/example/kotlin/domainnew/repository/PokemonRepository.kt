package com.example.kotlin.domainnew.repository

import androidx.paging.Pager
import com.example.kotlin.domainnew.models.Pokemon

interface PokemonRepository {
    fun getPokemonPager(): Pager<Int, Pokemon>
}
