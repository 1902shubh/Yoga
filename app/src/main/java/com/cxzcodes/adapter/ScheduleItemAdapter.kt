package com.cxzcodes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.Data.Schedule
import com.cxzcodes.yoga.R

class ScheduleItemAdapter(private val scheduleList: List<Schedule>?) :
    RecyclerView.Adapter<ScheduleItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.day_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val schedule = scheduleList?.get(position)
        holder.titleTextView.text = schedule?.title
    }

    override fun getItemCount(): Int {
        return scheduleList?.size ?: 0
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.dayNameTextView)
    }
}
