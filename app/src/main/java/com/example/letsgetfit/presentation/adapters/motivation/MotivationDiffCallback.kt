package com.example.letsgetfit.presentation.adapters.motivation

import androidx.recyclerview.widget.DiffUtil
import com.example.letsgetfit.domain.pojo.MotivationInfo

class MotivationDiffCallback:DiffUtil.ItemCallback<MotivationInfo>() {
    override fun areItemsTheSame(oldItem: MotivationInfo, newItem: MotivationInfo): Boolean {
        return oldItem.image == newItem.image
    }

    override fun areContentsTheSame(oldItem: MotivationInfo, newItem: MotivationInfo): Boolean {
        return oldItem == newItem
    }
}