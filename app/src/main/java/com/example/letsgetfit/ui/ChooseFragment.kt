package com.example.letsgetfit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.letsgetfit.R
import com.example.letsgetfit.databinding.FragmentChooseBinding


class ChooseFragment : Fragment() {

    private var _binding: FragmentChooseBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                isEnabled = false
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val training = binding.buttonTrainingChoose
        val nutrition = binding.buttonNutritionChoose
        val motivation = binding.buttonMotivationChoose

        training.setOnClickListener {
            findNavController().navigate(R.id.action_chooseFragment_to_trainingFragment)
        }

        nutrition.setOnClickListener {
            findNavController().navigate(R.id.action_chooseFragment_to_nutritionFragment)
        }

        motivation.setOnClickListener {
            findNavController().navigate(R.id.action_chooseFragment_to_motivationFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}