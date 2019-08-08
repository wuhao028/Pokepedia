package com.wuhao028.pokepedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.wuhao028.pokepedia.data.AppDatabase
import com.wuhao028.pokepedia.data.Generation
import com.wuhao028.pokepedia.data.Pokemon
import com.wuhao028.pokepedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        navController = findNavController(R.id.pokemon_nav_fragment)
        binding.navigationView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        AppDatabase.getInstance(this).generationDao().getGenerations()
            .observe(this, Observer<List<Generation>>() {
                println("@@generation size: " + it.size)
            })
        AppDatabase.getInstance(this).pokemonDao().getPokemonByRange(1, 251)
            .observe(this, Observer<List<Pokemon>>() {
                println("@@Pokemon size: " + it.size)
            })
        AppDatabase.getInstance(this).pokemonDao().getPokemon(1).observe(this, Observer<Pokemon>() {
            println("@@Pokemon name: " + it?.name?.get("english"))
        })
    }
}
