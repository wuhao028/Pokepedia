package com.wuhao028.pokepedia.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wuhao028.pokepedia.data.Pokemon
import com.wuhao028.pokepedia.data.PokemonRepository

class PokemonListViewModel internal constructor
    (pokemonRepository: PokemonRepository) : ViewModel() {

    val pokemons: LiveData<List<Pokemon>> = pokemonRepository.getPokemons()
}