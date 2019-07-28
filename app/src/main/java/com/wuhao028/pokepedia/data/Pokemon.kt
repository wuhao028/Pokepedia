package com.wuhao028.pokepedia.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemons")
data class Pokemon(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    val type: List<String>,
    val favored: Boolean = false,
    val name: Map<String, String>,
    val base: Map<String, Int>
) {
    override fun toString() = id.toString()
}