package com.wuhao028.pokepedia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wuhao028.pokepedia.PokeListFragmentDirections
import com.wuhao028.pokepedia.data.Pokemon
import com.wuhao028.pokepedia.databinding.ListItemPokemonBinding

class PokemonAdapter:
    ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(PokemonDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.apply {
            bind(createOnClickListener(pokemon.id), pokemon)
            itemView.tag = pokemon
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemPokemonBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    private fun createOnClickListener(plantId: Int): View.OnClickListener {
        return View.OnClickListener {
            val direction = PokeListFragmentDirections.actionPlantListFragmentToPlantDetailFragment(plantId.toString())
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(private val binding: ListItemPokemonBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Pokemon) {
            binding.apply {
                clickListener = listener
                pokemon  = item
                executePendingBindings()
            }
        }
    }
}

private class PokemonDiffCallback : DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
        return oldItem == newItem
    }
}