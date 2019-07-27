package com.wuhao028.pokepedia.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class Pokemon(
    @PrimaryKey @ColumnInfo(name = "id") val pokemonId: String,
    val name: String,
    val description: String,
    val imageUrl: String = ""
) {

    override fun toString() = name
}