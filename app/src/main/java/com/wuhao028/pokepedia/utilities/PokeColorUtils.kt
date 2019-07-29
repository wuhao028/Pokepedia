package com.wuhao028.pokepedia.utilities

import com.wuhao028.pokepedia.R

object PokeColorUtils {

    @JvmStatic
    fun getColorByType(type: String): Int {
        var result: Int = R.drawable.round_grass
        when (type) {
            "Grass" -> result = R.drawable.round_grass
            "Fire" -> result = R.drawable.round_fire
            "Water" -> result = R.drawable.round_water
            else -> result = R.drawable.round_grass
        }
        return result
    }
}