package com.example.kotlin.data.mappers

import com.example.kotlin.data.models.PokemonResponse
import com.example.kotlin.domain.models.Pokemon
import javax.inject.Inject

class PokemonResponseMapper @Inject constructor() : Mapper<PokemonResponse, Pokemon> {
    override fun toDomain(from: PokemonResponse): Pokemon {
        return Pokemon(from.name, from.url, from.imageUrl)
    }
}
