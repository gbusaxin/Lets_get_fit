package com.example.letsgetfit.presentation.adapters.motivation

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.letsgetfit.R
import com.example.letsgetfit.domain.pojo.MotivationInfo

class MotivationAdapter :
    ListAdapter<MotivationInfo, MotivationViewHolder>(MotivationDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotivationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_motivation,
            parent,
            false
        )
        return MotivationViewHolder(view)
    }

    override fun onBindViewHolder(holder: MotivationViewHolder, position: Int) {
        val item = getItem(position)
        Glide.with(holder.itemView.context).load(item.image)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(dr: Drawable, tran: Transition<in Drawable?>?) {
                    holder.image.setImageDrawable(dr)
                }

                override fun onLoadCleared(p0: Drawable?) {

                }
            })
        holder.author.text = item.author
        holder.message.text = item.message
    }
}