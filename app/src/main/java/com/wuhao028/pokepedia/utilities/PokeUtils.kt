package com.wuhao028.pokepedia.utilities

import com.wuhao028.pokepedia.R

object PokeUtils {

    @JvmStatic
    fun getColorByType(type: String): Int {
        var result: Int = R.drawable.background_grass
        when (type) {
            "Bug" -> result = R.drawable.background_bug
            "Grass" -> result = R.drawable.background_grass
            "Fire" -> result = R.drawable.background_fire
            "Water" -> result = R.drawable.background_water
            "Dark" -> result = R.drawable.background_dark
            "Dragon" -> result = R.drawable.background_dragon
            "Electric" -> result = R.drawable.background_electric
            "Fairy" -> result = R.drawable.background_fairy
            "Fighting" -> result = R.drawable.background_fighting
            "Flying" -> result = R.drawable.background_flying
            "Ghost" -> result = R.drawable.background_ghost
            "Ground" -> result = R.drawable.background_ground
            "Ice" -> result = R.drawable.background_ice
            "Normal" -> result = R.drawable.background_normal
            "Poison" -> result = R.drawable.background_poison
            "Psychic" -> result = R.drawable.background_psychic
            "Rock" -> result = R.drawable.background_rock
            "Steel" -> result = R.drawable.background_steel
            else -> result = R.drawable.background_grass
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