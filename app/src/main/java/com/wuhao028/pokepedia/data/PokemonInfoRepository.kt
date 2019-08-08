package com.wuhao028.pokepedia.data

class PokemonInfoRepository private constructor(private val pokemondao: PokemonDao) {


    companion object {
        @Volatile
        private var instance: PokemonInfoRepository? = null

        fun getInstance(pokemondao: PokemonDao) =
            instance ?: synchronized(this) {
                instance ?: PokemonInfoRepository(pokemondao).also { instance = it }
            }
    }

}
