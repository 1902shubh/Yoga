package com.cxzcodes.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.Data.ItemSlide
import com.cxzcodes.helper.Utils.a_schedule
import com.cxzcodes.yoga.R
import com.cxzcodes.yoga.YogaDayActivity

class ItemSlideAdapter(private val items: List<ItemSlide>, private val context: Context) :
    RecyclerView.Adapter<ItemSlideAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.iv)
        val itemText: TextView = itemView.findViewById(R.id.tvnameyoga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.slide_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.itemImage.setImageResource(item.imageResId)

        holder.itemText.text = item.text
        holder.itemView.setOnClickListener {

            val inte = Intent(context, YogaDayActivity::class.java)
             inte.putExtra("type", position)
            context.startActivity(inte)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
