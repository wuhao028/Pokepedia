package com.wuhao028.pokepedia.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "generations")
data class Generation(
    @PrimaryKey @ColumnInfo(name = "id") val generationId: String,
    val name: String,
    val description: String,
    val imageUrl: String = ""
) {

    override fun toString() = name
}