package com.example.letsgetfit.presentation.adapters.training

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.letsgetfit.R
import com.example.letsgetfit.domain.pojo.TrainingItem

class TrainingDetailAdapter :
    ListAdapter<TrainingItem, TrainingDetailViewHolder>(TrainingDetailDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingDetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_training_detail,
            parent,
            false
        )
        return TrainingDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrainingDetailViewHolder, position: Int) {
        val item = getItem(position)
        holder.exercise.text = item.exercise
        holder.title.text = item.title
        Glide.with(holder.itemView.context).load(item.image)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(dr: Drawable, tran: Transition<in Drawable?>?) {
                    holder.image.setImageDrawable(dr)
                }

                override fun onLoadCleared(p0: Drawable?) {

                }
            })
    }
}