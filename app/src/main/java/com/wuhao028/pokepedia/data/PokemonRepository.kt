package com.wuhao028.pokepedia.data

class PokemonRepository private constructor(private val pokemondao: PokemonDao) {

    fun getPokemon(id: Int) = pokemondao.getPokemon(id)

    fun getPokemons(min:Int,max:Int) = pokemondao.getPokemonByRange(min,max)

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