package com.example.letsgetfit.ui.motivation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.letsgetfit.R
import com.example.letsgetfit.databinding.FragmentMotivationBinding
import com.example.letsgetfit.presentation.ViewModelMotivation
import com.example.letsgetfit.presentation.adapters.motivation.MotivationAdapter

class MotivationFragment : Fragment() {

    private var _binding: FragmentMotivationBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: ViewModelMotivation
    private lateinit var adapter: MotivationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMotivationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recyclerViewMotivation
        viewModel = ViewModelProvider(this)[ViewModelMotivation::class.java]
        adapter = MotivationAdapter()
        viewModel.getMotivationList.observe(viewLifecycleOwner,{
            adapter.submitList(it)
            recyclerView.adapter = adapter
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}