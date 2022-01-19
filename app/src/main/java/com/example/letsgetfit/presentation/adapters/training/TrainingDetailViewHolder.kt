package com.example.letsgetfit.presentation.adapters.training

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.letsgetfit.databinding.ItemTrainingDetailBinding

class TrainingDetailViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    private val binding = ItemTrainingDetailBinding.bind(itemView)
    val image = binding.imageViewDetailExercise
    val title = binding.textViewDetailTitle
    val exercise = binding.textViewDetailExercise
}