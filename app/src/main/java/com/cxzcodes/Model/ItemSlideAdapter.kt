package com.cxzcodes.Model

import android.content.ClipData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.Data.ItemSlide
import com.cxzcodes.yoga.R

class ItemSlideAdapter(private val items: List<ItemSlide>) : RecyclerView.Adapter<ItemSlideAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.iv)
        val itemText: TextView = itemView.findViewById(R.id.tvnameyoga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.slide_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemImage.setImageResource(item.imageResId)
        holder.itemText.text = item.text
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
