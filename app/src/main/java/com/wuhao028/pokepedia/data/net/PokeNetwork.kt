package com.wuhao028.pokepedia.data.net

import com.wuhao028.pokepedia.data.net.api.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class PokeNetwork {

    private val pokemonService = ServiceCreator.create(PokemonService::class.java)

    suspend fun fetchPokemon(pokemonId: Int) = pokemonService.getPokemon(pokemonId).await()

    private suspend fun <T> Call<T>.await(): T {
        return suspendCoroutine { continuation ->
            enqueue(object : Callback<T> {
                override fun onFailure(call: Call<T>, t: Throwable) {
                    continuation.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>, response: Response<T>) {
                    val body = response.body()
                    if (body != null) continuation.resume(body)
                    else continuation.resumeWithException(RuntimeException("response body is null"))
                }
            })
        }
    }

    companion object {

        private var network: PokeNetwork? = null

        fun getInstance(): PokeNetwork {
            if (network == null) {
                synchronized(PokeNetwork::class.java) {
                    if (network == null) {
                        network = PokeNetwork()
                    }
                }
            }
            return network!!
        }

    }

}