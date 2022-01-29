package com.example.swipableviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(
    val images: List<Int>
): RecyclerView.Adapter<ViewPagerAdapter.ViewPAgerViewHolder>() {
    class ViewPAgerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImage : ImageView

        init {
            ivImage = itemView.findViewById(R.id.ivImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPAgerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPAgerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPAgerViewHolder, position: Int) {
        val curImage = images[position]
        holder.ivImage.setImageResource(curImage)
    }

    override fun getItemCount(): Int {
        return images.size
    }
}