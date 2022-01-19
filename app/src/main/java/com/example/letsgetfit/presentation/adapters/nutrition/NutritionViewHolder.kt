package com.example.letsgetfit.presentation.adapters.nutrition

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.letsgetfit.databinding.ItemNutritionBinding

class NutritionViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    private val binding = ItemNutritionBinding.bind(itemView)
    val title = binding.textViewNutritionTitle
    val shortDesc = binding.textViewNutritionShortDesc
    val date = binding.textViewNutritionDate
    val image = binding.imageView
}