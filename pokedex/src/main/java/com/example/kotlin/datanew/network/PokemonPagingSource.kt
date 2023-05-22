package com.example.kotlin.datanew.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin.datanew.mappers.PokemonDetailsMapper
import com.example.kotlin.datanew.mappers.PokemonResponseMapper
import com.example.kotlin.domainnew.models.Pokemon
import com.example.kotlin.getPageFromUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class PokemonPagingSource @Inject constructor(
    private val pokemonService: PokemonService,
    private val pokemonResponseMapper: PokemonResponseMapper,
    private val pokemonDetailsMapper: PokemonDetailsMapper,
) : PagingSource<Int, Pokemon>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val nextPageNumber = params.key ?: 0
        return try {

            withContext(Dispatchers.IO){
                val networkResponse = pokemonService.pokemonList(nextPageNumber * 20)

                if (networkResponse.isSuccessful && networkResponse.body() != null) {
                    val responseBody = networkResponse.body()!!
                    val pokemonList = pokemonResponseMapper.toDomain(responseBody.results)
                    val prevPage = getPageFromUrl(responseBody.previous)
                    val nextPage = getPageFromUrl(responseBody.next)

                    pokemonList.map { pokemon: Pokemon ->
                        async { getPokemonDetails(pokemon) }
                    }.awaitAll()

                    return@withContext LoadResult.Page(
                        pokemonList,
                        prevKey = prevPage,
                        nextKey = nextPage
                    )
                } else {
                    return@withContext LoadResult.Error(
                        Throwable(
                            networkResponse.errorBody()?.string()
                        )
                    )
                }
            }
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    // Try to find the page key of the closest page to anchorPosition, from
    // either the prevKey or the nextKey, but you need to handle nullability
    // here:
    //  * prevKey == null -> anchorPage is the first page.
    //  * nextKey == null -> anchorPage is the last page.
    //  * both prevKey and nextKey null -> anchorPage is the initial page, so
    //    just return null.
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private suspend fun getPokemonDetails(pokemon: Pokemon) {
        withContext(Dispatchers.Default) {
            val networkResponse = pokemonService.pokemonDetails(pokemon.name)
            if (networkResponse.isSuccessful && networkResponse.body() != null) {
                val pokemonDetails = networkResponse.body()!!
                pokemon.pokemonDetails = pokemonDetailsMapper.toDomain(pokemonDetails)
            }
        }
    }
}
