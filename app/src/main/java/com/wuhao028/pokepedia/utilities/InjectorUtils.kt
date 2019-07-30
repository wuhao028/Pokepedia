package com.wuhao028.pokepedia.utilities

import android.content.Context
import com.wuhao028.pokepedia.data.AppDatabase
import com.wuhao028.pokepedia.data.GenerationRepository
import com.wuhao028.pokepedia.data.PokemonRepository
import com.wuhao028.pokepedia.viewmodels.GenerationListViewModelFactory
import com.wuhao028.pokepedia.viewmodels.PokemonListViewModelFactory

object InjectorUtils {


    private fun getGenerationRepository(context: Context): GenerationRepository {
        return GenerationRepository.getInstance(AppDatabase.getInstance(context.applicationContext).generationDao())
    }

    private fun getPokemonRepository(context: Context): PokemonRepository {
        return PokemonRepository.getInstance(AppDatabase.getInstance(context.applicationContext).pokemonDao())
    }

    fun provideGenerationListViewModelFactory(context: Context): GenerationListViewModelFactory {
        val repository = getGenerationRepository(context)
        return GenerationListViewModelFactory(repository)
    }

    fun providePokemonListViewModelFactory(context: Context,generationId: String): PokemonListViewModelFactory {
        val repository = getPokemonRepository(context)
        return PokemonListViewModelFactory(repository,generationId)
    }

}