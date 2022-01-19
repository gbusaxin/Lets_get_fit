package com.example.letsgetfit.presentation.adapters.training

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.letsgetfit.databinding.ItemTrainingBinding

class TrainingViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    private val bind = ItemTrainingBinding.bind(itemView)
     val trainer = bind.textViewTrainerTraining
     val aboutTrainer = bind.textViewAboutTrainerTraining
}