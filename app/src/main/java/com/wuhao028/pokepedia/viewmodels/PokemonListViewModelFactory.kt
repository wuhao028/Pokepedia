package com.wuhao028.pokepedia.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wuhao028.pokepedia.data.PokemonRepository

class PokemonListViewModelFactory(
    private val repository: PokemonRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        PokemonListViewModel(repository) as T
}