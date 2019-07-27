package com.wuhao028.pokepedia.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface GenerationDao {
    @Query("SELECT * FROM generations ORDER BY name")
    fun getGenerations(): LiveData<List<Generation>>

    @Query("SELECT * FROM generations WHERE id = :generationId")
    fun getGeneration(generationId: String): LiveData<Generation>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<Generation>)
}