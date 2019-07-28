package com.wuhao028.pokepedia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.wuhao028.pokepedia.adapters.GenerationAdapter
import com.wuhao028.pokepedia.adapters.PokemonAdapter
import com.wuhao028.pokepedia.databinding.FragmentHomeBinding
import com.wuhao028.pokepedia.databinding.FragmentListBinding
import com.wuhao028.pokepedia.utilities.InjectorUtils
import com.wuhao028.pokepedia.viewmodels.GenerationListViewModel
import com.wuhao028.pokepedia.viewmodels.PokemonListViewModel

class PokeListFragment : Fragment() {

    private val viewModel: PokemonListViewModel by viewModels {
        InjectorUtils.providePokemonListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentListBinding.inflate(inflater, container, false)
        context ?: return binding.root
        val adapter = PokemonAdapter()
        binding.pokemonList.adapter = adapter
        subscribeUi(adapter)
        return binding.root
    }

    private fun subscribeUi(adapter: PokemonAdapter) {
        viewModel.pokemons.observe(viewLifecycleOwner) { pokemon ->
            if (pokemon != null) adapter.submitList(pokemon)
        }
    }


}