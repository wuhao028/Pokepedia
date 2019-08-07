package com.wuhao028.pokepedia.net

import com.wuhao028.pokepedia.data.PokemonInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService{

    @GET("pokemon/{pokemonId}")
    fun getPokemon(@Path("pokemonId") pokemonId: Int): Call<MutableList<PokemonInfo>>

}