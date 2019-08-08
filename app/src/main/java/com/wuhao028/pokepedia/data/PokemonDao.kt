package com.wuhao028.pokepedia.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemons ORDER BY id")
    fun getPokemons(): LiveData<List<Pokemon>>

    @Query("SELECT * FROM pokemons WHERE id = :pokemonId")
    fun getPokemon(pokemonId: Int): LiveData<Pokemon>

    @Query("SELECT * FROM pokemons WHERE id Between :pokemonIdMin AND :pokemonIdMax")
    fun getPokemonByRange(pokemonIdMin: Int, pokemonIdMax: Int): LiveData<List<Pokemon>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<Pokemon>)
}