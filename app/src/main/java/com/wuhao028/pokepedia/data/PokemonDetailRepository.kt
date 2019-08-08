package com.wuhao028.pokepedia.data

class PokemonDetailRepository private constructor(private val pokemondao: PokemonDao) {


    companion object {
        @Volatile
        private var instance: PokemonDetailRepository? = null

        fun getInstance(pokemondao: PokemonDao) =
            instance ?: synchronized(this) {
                instance ?: PokemonDetailRepository(pokemondao).also { instance = it }
            }
    }

}
