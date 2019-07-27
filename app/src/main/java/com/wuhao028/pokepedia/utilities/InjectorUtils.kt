package com.wuhao028.pokepedia.utilities

import android.content.Context
import com.wuhao028.pokepedia.data.AppDatabase
import com.wuhao028.pokepedia.data.GenerationRepository
import com.wuhao028.pokepedia.viewmodels.GenerationListViewModelFactory

object InjectorUtils {


    private fun getGenerationRepository(context: Context): GenerationRepository {
        return GenerationRepository.getInstance(AppDatabase.getInstance(context.applicationContext).generationDao())
    }

    fun provideGenerationListViewModelFactory(context: Context): GenerationListViewModelFactory {
        val repository = getGenerationRepository(context)
        return GenerationListViewModelFactory(repository)
    }

}