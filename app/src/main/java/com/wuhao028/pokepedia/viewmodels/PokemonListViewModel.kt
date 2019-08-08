package com.wuhao028.pokepedia.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wuhao028.pokepedia.data.Pokemon
import com.wuhao028.pokepedia.data.PokemonRepository
import com.wuhao028.pokepedia.utilities.PokeUtils

class PokemonListViewModel internal constructor
    (pokemonRepository: PokemonRepository, generationId: String) : ViewModel() {

    val pokemons: LiveData<List<Pokemon>>

    init {
        pokemons = pokemonRepository.getPokemons(
            PokeUtils.getGetGenRange(generationId)[0]
            , PokeUtils.getGetGenRange(generationId)[1]
        )
    }

}