package com.example.letsgetfit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.letsgetfit.R
import com.example.letsgetfit.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = binding.buttonReadyWelcome
        val name = binding.editTextNameWelcome.text.toString()
        val surname = binding.editTextSurnameWelcome.text.toString()

        button.setOnClickListener {
            if (!name.equals("") && !surname.equals("")) {
                findNavController().navigate(R.id.action_welcomeFragment_to_chooseFragment)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Поля \"Имя\" и \"Фамилия\" должны быть заполнены!", Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}