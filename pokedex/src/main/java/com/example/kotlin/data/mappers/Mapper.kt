package com.example.kotlin.data.mappers

interface Mapper<in Data, out Domain> {
    fun toDomain(from: Data): Domain

    fun toDomain(from: List<Data>): List<Domain> {
        return from.map { toDomain(it) }
    }
}
