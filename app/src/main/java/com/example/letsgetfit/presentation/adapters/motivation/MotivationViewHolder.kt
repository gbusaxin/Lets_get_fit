package com.example.letsgetfit.presentation.adapters.motivation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.letsgetfit.databinding.ItemMotivationBinding

class MotivationViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    private val binding = ItemMotivationBinding.bind(itemView)
    val image = binding.imageViewMotivationImage
    val author = binding.textViewMotivationAuthor
    val message = binding.textViewMotivationMessage
}