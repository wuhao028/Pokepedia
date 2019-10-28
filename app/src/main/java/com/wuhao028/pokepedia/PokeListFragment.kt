package com.wuhao028.pokepedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.wuhao028.pokepedia.adapters.PokemonAdapter
import com.wuhao028.pokepedia.databinding.FragmentListBinding
import com.wuhao028.pokepedia.utilities.InjectorUtils
import com.wuhao028.pokepedia.viewmodels.PokemonListViewModel

class PokeListFragment : Fragment() {

    private val args: PokeListFragmentArgs by navArgs()
    private val viewModel: PokemonListViewModel by viewModels {
        InjectorUtils.providePokemonListViewModelFactory(requireContext(), args.generationId)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater, container, false)
        context ?: return binding.root
        val adapter = PokemonAdapter()
        Glide.with(this.requireContext())
            .load(R.mipmap.loading)
            .into(binding.pokemonProgress)
        binding.pokemonProgress.visibility = View.VISIBLE
        binding.pokemonList.adapter = adapter
        binding.pokemonList.layoutManager = GridLayoutManager(requireContext(), 2)
        subscribeUi(adapter, binding)
        return binding.root
    }

    private fun subscribeUi(adapter: PokemonAdapter, binding: FragmentListBinding) {
        viewModel.pokemons.observe(viewLifecycleOwner) { pokemon ->
            pokemon?.let {
                binding.pokemonProgress.visibility = View.GONE
                binding.pokemonList.visibility = View.VISIBLE
                adapter.submitList(pokemon)
            }
        }
    }

}