package com.example.letsgetfit.ui.training

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.letsgetfit.R
import com.example.letsgetfit.databinding.FragmentTrainingDetailBinding
import com.example.letsgetfit.presentation.ViewModelTraining
import com.example.letsgetfit.presentation.adapters.training.TrainingDetailAdapter
import com.example.letsgetfit.ui.MainActivity

class TrainingDetailFragment : Fragment() {

    private var _binding: FragmentTrainingDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter:TrainingDetailAdapter
    private val viewModel: ViewModelTraining by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrainingDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val trainer = binding.textViewDetailTrainer
        var image = binding.imageViewDetailImage
        val about = binding.textViewDetailAbout
        val recyclerView = binding.recyclerViewDetailTraining
        adapter = TrainingDetailAdapter()
        viewModel.selectedTraining.observe(viewLifecycleOwner, {
            trainer.text = it.trainer
            about.text = it.aboutTrainer
            Glide.with(this).load(it.imageTrainer)
                .into(object : CustomTarget<Drawable>() {
                    override fun onResourceReady(dr: Drawable, tran: Transition<in Drawable?>?) {
                        image.setImageDrawable(dr)
                    }

                    override fun onLoadCleared(p0: Drawable?) {

                    }
                })
            adapter.submitList(it.training)
            recyclerView.adapter = adapter
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}