package com.example.kotlin.datanew.mappers

import com.example.kotlin.datanew.models.PokemonResponse
import com.example.kotlin.domainnew.models.Pokemon
import javax.inject.Inject

class PokemonResponseMapper @Inject constructor() : Mapper<PokemonResponse, Pokemon> {
    override fun toDomain(from: PokemonResponse): Pokemon {
        return Pokemon(from.name, from.url, from.imageUrl)
    }
}
