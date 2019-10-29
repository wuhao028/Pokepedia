package com.wuhao028.pokepedia

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.wuhao028.pokepedia.adapters.GenerationAdapter
import com.wuhao028.pokepedia.databinding.FragmentHomeBinding
import com.wuhao028.pokepedia.utilities.InjectorUtils
import com.wuhao028.pokepedia.viewmodels.GenerationListViewModel

class HomeFragment : Fragment() {

    private val viewModel: GenerationListViewModel by viewModels {
        InjectorUtils.provideGenerationListViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root
        val adapter = GenerationAdapter()
        binding.generationList.adapter = adapter
        binding.generationList.isNestedScrollingEnabled = false
        binding.generationList.isFocusable = false
        subscribeUi(adapter)
        val animator = ObjectAnimator.ofFloat(binding.homePokeball, "rotation", 0f, 360f)
        animator.duration = 2000
        animator.repeatCount = -1
        animator.repeatMode = ValueAnimator.RESTART
        animator.start()
        return binding.root
    }

    private fun subscribeUi(adapter: GenerationAdapter) {
        viewModel.generations.observe(viewLifecycleOwner) { generation ->
            adapter.submitList(generation)
        }
    }

}