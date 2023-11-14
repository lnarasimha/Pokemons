package com.example.kotlin.data.mappers

import com.example.kotlin.data.models.PokemonDetailsResponse
import com.example.kotlin.domain.models.PokemonDetails
import javax.inject.Inject

class PokemonDetailsMapper @Inject constructor() : Mapper<PokemonDetailsResponse, PokemonDetails> {

    override fun toDomain(from: PokemonDetailsResponse): PokemonDetails {
        return PokemonDetails(from.name, from.height, from.weight, from.experience)
    }
}
