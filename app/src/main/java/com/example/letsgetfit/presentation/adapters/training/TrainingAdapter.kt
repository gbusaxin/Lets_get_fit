package com.example.letsgetfit.presentation.adapters.training

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.letsgetfit.R
import com.example.letsgetfit.domain.pojo.TrainingInfo

class TrainingAdapter: ListAdapter<TrainingInfo,TrainingViewHolder>(TrainingDiffCallback()) {

    var onTrainingClickListener : ((TrainingInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_training,
            parent,
            false
        )
        return TrainingViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val item = getItem(position)
        holder.trainer.text = item.trainer
        holder.aboutTrainer.text = item.aboutTrainer
        holder.itemView.setOnClickListener {
            onTrainingClickListener?.invoke(item)
        }
    }
}