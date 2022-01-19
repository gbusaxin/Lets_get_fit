package com.example.letsgetfit.presentation.adapters.nutrition

import android.app.AlertDialog
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.letsgetfit.R
import com.example.letsgetfit.domain.pojo.NutritionInfo

class NutritionAdapter : ListAdapter<NutritionInfo, NutritionViewHolder>(NutritionDiffCallback()) {

    var onNutritionClickListener: ((NutritionInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_nutrition,
            parent,
            false
        )
        return NutritionViewHolder(view)
    }

    override fun onBindViewHolder(holder: NutritionViewHolder, position: Int) {
        val item = getItem(position)

        Glide.with(holder.itemView.context).load(item.backgroundImage)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(dr: Drawable, tran: Transition<in Drawable?>?) {
                    holder.image.setImageDrawable(dr)
                }

                override fun onLoadCleared(p0: Drawable?) {

                }
            })

        holder.date.text = item.date
        holder.shortDesc.text = item.shortDesc
        holder.title.text = item.title
        holder.itemView.setOnClickListener {
            onNutritionClickListener?.invoke(item)
            AlertDialog
                .Builder(holder.itemView.context)
                .setTitle(item.title)
                .setMessage(item.description)
                .setNegativeButton(
                    "Закрыть"
                ) { p0, p1 -> p0?.cancel() }
                .show()
        }
    }
}