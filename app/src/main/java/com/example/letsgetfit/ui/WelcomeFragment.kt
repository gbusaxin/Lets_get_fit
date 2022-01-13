package com.example.letsgetfit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
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

        binding.apply {
            if (editTextNameWelcome.text.toString() != "" &&
                editTextSurnameWelcome.text.toString() != ""
            ) {
                buttonReadyWelcome.setOnClickListener {
                    onEnterClickListener()
                }
            }
        }

    }

    fun onEnterClickListener() {
        findNavController().navigate(R.id.action_welcomeFragment_to_chooseFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}