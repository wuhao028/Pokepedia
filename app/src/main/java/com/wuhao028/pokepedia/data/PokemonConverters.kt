package com.wuhao028.pokepedia.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PokemonConverters {

    @TypeConverter
    fun getTypeFromString(value: String): List<String>? {
        return value.split(",")
    }

    @TypeConverter
    fun storeTypeToString(list: List<String>): String {
        val str = StringBuilder(list[0])
        list.forEach {
            str.append(",").append(it)
        }
        return str.toString()
    }

    @TypeConverter
    fun fromString(value: String): Map<String, String> {
        val mapType = object : TypeToken<Map<String, String>>() {

        }.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromStringMap(map: Map<String, String>): String {
        val gson = Gson()
        return gson.toJson(map)
    }

    @TypeConverter
    fun fromStringToMap(value: String): Map<String, Int> {
        val mapType = object : TypeToken<Map<String, Int>>() {

        }.type
        return Gson().fromJson(value, mapType)
    }

    @TypeConverter
    fun fromStringIntToMap(map: Map<String, Int>): String {
        val gson = Gson()
        return gson.toJson(map)
    }

}