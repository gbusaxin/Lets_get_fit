package com.example.letsgetfit.presentation.adapters.nutrition

import androidx.recyclerview.widget.DiffUtil
import com.example.letsgetfit.domain.pojo.NutritionInfo

class NutritionDiffCallback:DiffUtil.ItemCallback<NutritionInfo>() {
    override fun areItemsTheSame(oldItem: NutritionInfo, newItem: NutritionInfo): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: NutritionInfo, newItem: NutritionInfo): Boolean {
        return oldItem == newItem
    }
}