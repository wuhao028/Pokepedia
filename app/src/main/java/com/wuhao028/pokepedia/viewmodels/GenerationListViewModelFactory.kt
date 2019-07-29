package com.wuhao028.pokepedia.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wuhao028.pokepedia.data.GenerationRepository

class GenerationListViewModelFactory(
    private val repository: GenerationRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        GenerationListViewModel(repository) as T
}
