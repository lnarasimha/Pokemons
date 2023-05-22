package com.example.kotlin.datanew.mappers

import com.example.kotlin.datanew.models.PokemonDetailsResponse
import com.example.kotlin.domainnew.models.PokemonDetails
import javax.inject.Inject

class PokemonDetailsMapper @Inject constructor() : Mapper<PokemonDetailsResponse, PokemonDetails> {

    override fun toDomain(from: PokemonDetailsResponse): PokemonDetails {
        return PokemonDetails(from.name, from.height, from.weight, from.experience)
    }
}
