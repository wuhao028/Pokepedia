package com.wuhao028.pokepedia.data

class PokemonRepository private constructor(private val pokemondao: PokemonDao) {

    fun getPokemon(id: Int) = pokemondao.getPokemon(id)

    fun getPokemons() = pokemondao.getPokemons()

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: PokemonRepository? = null

        fun getInstance(pokemondao: PokemonDao) =
            instance ?: synchronized(this) {
                instance ?: PokemonRepository(pokemondao).also { instance = it }
            }
    }

}