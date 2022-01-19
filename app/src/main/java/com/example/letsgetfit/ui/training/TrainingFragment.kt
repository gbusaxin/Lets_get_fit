package com.example.letsgetfit.ui.training

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.letsgetfit.R
import com.example.letsgetfit.databinding.FragmentTrainingBinding
import com.example.letsgetfit.presentation.ViewModelTraining
import com.example.letsgetfit.presentation.adapters.training.TrainingAdapter

class TrainingFragment : Fragment() {

    private var _binding:FragmentTrainingBinding? = null
    private val binding get() = _binding!!
    private val viewModel:ViewModelTraining by activityViewModels()
    private lateinit var trainingAdapter:TrainingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrainingBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvTraining = binding.rvTraining
        trainingAdapter = TrainingAdapter()

        viewModel.trainingList.observe(viewLifecycleOwner,{
            trainingAdapter.submitList(it)
            rvTraining.adapter = trainingAdapter
        })
        trainingAdapter.onTrainingClickListener = {
            viewModel.selectTraining(it)
            findNavController().navigate(R.id.action_trainingFragment_to_trainingDetailFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}