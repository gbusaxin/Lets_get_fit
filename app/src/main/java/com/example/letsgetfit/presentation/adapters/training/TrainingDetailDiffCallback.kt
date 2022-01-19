package com.example.letsgetfit.presentation.adapters.training

import androidx.recyclerview.widget.DiffUtil
import com.example.letsgetfit.domain.pojo.TrainingItem

class TrainingDetailDiffCallback:DiffUtil.ItemCallback<TrainingItem>() {
    override fun areItemsTheSame(oldItem: TrainingItem, newItem: TrainingItem): Boolean {
        return oldItem.title == newItem.exercise
    }

    override fun areContentsTheSame(oldItem: TrainingItem, newItem: TrainingItem): Boolean {
        return oldItem == newItem
    }
}