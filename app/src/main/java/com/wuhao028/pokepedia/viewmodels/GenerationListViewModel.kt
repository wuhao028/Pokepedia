package com.wuhao028.pokepedia.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.wuhao028.pokepedia.data.Generation
import com.wuhao028.pokepedia.data.GenerationRepository

class GenerationListViewModel internal constructor
    (generationRepository: GenerationRepository) : ViewModel() {

    val generations: LiveData<List<Generation>> = generationRepository.getGenerations()

}