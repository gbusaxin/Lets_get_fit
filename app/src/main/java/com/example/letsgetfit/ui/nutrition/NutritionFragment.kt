package com.example.letsgetfit.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.letsgetfit.databinding.FragmentNutritionBinding
import com.example.letsgetfit.presentation.ViewModelNutrition
import com.example.letsgetfit.presentation.adapters.nutrition.NutritionAdapter


class NutritionFragment : Fragment() {

    private var _binding: FragmentNutritionBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var viewModel:ViewModelNutrition
    private lateinit var adapter : NutritionAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNutritionBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recyclerViewNutrition
        viewModel = ViewModelProvider(this)[ViewModelNutrition::class.java]
        adapter = NutritionAdapter()

        viewModel.getNutritionList.observe(viewLifecycleOwner,{
            adapter.submitList(it)
            recyclerView.adapter = adapter
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}