package com.wuhao028.pokepedia.utilities

import com.wuhao028.pokepedia.R

object PokeUtils {

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

    @JvmStatic
    fun getGetGenRange(generationId: String): IntArray {
        when (generationId) {
            "1" -> return intArrayOf(1, 151)
            "2" -> return intArrayOf(152, 251)
            "3" -> return intArrayOf(252, 386)
            "4" -> return intArrayOf(387, 493)
            "5" -> return intArrayOf(494, 649)
            "6" -> return intArrayOf(650, 721)
            "7" -> return intArrayOf(722, 807)
            "8" -> return intArrayOf(808, 809)
            else -> {
                return intArrayOf(1, 151)
            }
        }
    }

}