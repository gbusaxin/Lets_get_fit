package com.example.letsgetfit.presentation.adapters.training

import androidx.recyclerview.widget.DiffUtil
import com.example.letsgetfit.domain.pojo.TrainingInfo

class TrainingDiffCallback : DiffUtil.ItemCallback<TrainingInfo>() {
    override fun areItemsTheSame(oldItem: TrainingInfo, newItem: TrainingInfo): Boolean {
        return oldItem.trainer == newItem.trainer
    }

    override fun areContentsTheSame(oldItem: TrainingInfo, newItem: TrainingInfo): Boolean {
        return oldItem == newItem
    }
}