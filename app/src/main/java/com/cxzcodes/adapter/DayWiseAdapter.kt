package com.cxzcodes.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.Data.Schedule
import com.cxzcodes.helper.Utils.yoga
import com.cxzcodes.yoga.R
import com.cxzcodes.yoga.YogaDetails

class DayWiseAdapter(private val itemlist: MutableList<Schedule>, val context: Context) :
    RecyclerView.Adapter<DayWiseAdapter.DayViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.day_wise_layout, parent, false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {

        val currenttitle = itemlist[position].title
        holder.dayNameTextView.text = currenttitle
        for (yogaModel in yoga) {
            if (currenttitle == yogaModel.title) {
                val imageid = yogaModel.img
                val imgResourceId = holder.itemView.context.resources.getIdentifier(
                    imageid, "drawable", holder.itemView.context.packageName
                )
                val imgDrawable = ContextCompat.getDrawable(holder.itemView.context, imgResourceId)
                holder.ivyoga.setImageDrawable(imgDrawable)
            }
        }
        holder.itemView.setOnClickListener {
            for (yogaModel in yoga) {
                if (currenttitle == yogaModel.title) {
                    val intent = Intent(context, YogaDetails::class.java)
                    intent.putExtra("title", yogaModel.title)
                    intent.putExtra("image", yogaModel.img)
                    intent.putExtra("desc", yogaModel.desc)
                    intent.putExtra("kruti", yogaModel.kruti)
                    intent.putExtra("laabh", yogaModel.laabh)
                    intent.putExtra("savadh", yogaModel.savadh)
                    context.startActivity(intent)
                    break
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }

    inner class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayNameTextView: TextView = itemView.findViewById(R.id.tvtitle)
        val ivyoga: ImageView = itemView.findViewById(R.id.ivyoga)

        fun bind(position: Int) {
            dayNameTextView.text = itemlist[position].title

        }
    }
}
