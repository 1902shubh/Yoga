package com.cxzcodes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.Data.Schedule
import com.cxzcodes.yoga.R

class DayWiseAdapter(private val itemlist:MutableList<Schedule>, val context:Context) : RecyclerView.Adapter<DayWiseAdapter.DayViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.day_layout, parent, false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    inner class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dayNameTextView: TextView = itemView.findViewById(R.id.dayNameTextView)
        private val dayImageView: ImageView = itemView.findViewById(R.id.dayImageView)

        fun bind(position: Int) {
             dayNameTextView.text = itemlist[position].title

             if ((position + 1) % 4 == 0) {
                dayImageView.visibility = View.VISIBLE
                dayNameTextView.visibility=View.GONE
                 dayImageView.setImageResource(R.drawable.yogawallpaper)
            } else {
                dayImageView.visibility = View.GONE
                dayNameTextView.visibility=View.VISIBLE

            }
        }
    }
}
