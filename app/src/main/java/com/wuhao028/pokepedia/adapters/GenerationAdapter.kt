package com.wuhao028.pokepedia.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wuhao028.pokepedia.HomeFragmentDirections
import com.wuhao028.pokepedia.PokeListFragmentArgs
import com.wuhao028.pokepedia.data.Generation
import com.wuhao028.pokepedia.databinding.ListItemGenerationBinding

class GenerationAdapter :
    ListAdapter<Generation, GenerationAdapter.ViewHolder>(PlantDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val generation = getItem(position)
        holder.apply {
            bind(createOnClickListener(generation.generationId), generation)
            itemView.tag = generation
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListItemGenerationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    private fun createOnClickListener(generationId: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = HomeFragmentDirections.actionGardenFragmentToPlantDetailFragment(generationId)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ListItemGenerationBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Generation) {
            binding.apply {
                clickListener = listener
                generation = item
                executePendingBindings()
            }
        }
    }
}

private class PlantDiffCallback : DiffUtil.ItemCallback<Generation>() {

    override fun areItemsTheSame(oldItem: Generation, newItem: Generation): Boolean {
        return oldItem.generationId == newItem.generationId
    }

    override fun areContentsTheSame(oldItem: Generation, newItem: Generation): Boolean {
        return oldItem == newItem
    }
}