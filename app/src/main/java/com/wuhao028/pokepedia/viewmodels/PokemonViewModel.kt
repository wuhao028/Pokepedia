package com.wuhao028.pokepedia.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wuhao028.pokepedia.data.PokemonInfo
import com.wuhao028.pokepedia.data.PokemonInfoRepository
import com.wuhao028.pokepedia.data.net.PokeNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel(
    pokemonInfoRepository: PokemonInfoRepository,
    pokemonId: Int
) : ViewModel() {

    var pokemonDetail = MutableLiveData<PokemonInfo>()

    fun getPokemonDetail() {
        launch({
            val pokemonInfo = requestWeather(1)
            pokemonDetail.value = requestWeather(1)

            Log.d("@@", "@@!@@ " + pokemonInfo.name)
        }, {

        })
    }


    private suspend fun requestWeather(pokemonId: Int) = withContext(Dispatchers.IO) {
        val pokemon = PokeNetwork.getInstance().fetchPokemon(pokemonId)
        pokemon
    }


    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) =
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                error(e)
            }
        }

}