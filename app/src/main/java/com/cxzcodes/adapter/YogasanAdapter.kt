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
import com.cxzcodes.Data.YogaModel
import com.cxzcodes.yoga.R
import com.cxzcodes.yoga.YogaDetails

class YogasanAdapter(private val yogaItems: MutableList<YogaModel>,val context:Context) : RecyclerView.Adapter<YogasanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = yogaItems[position]

         holder.titleTextView.text = item.title
         val imgResourceId = holder.itemView.context.resources.getIdentifier(
            item.img, "drawable", holder.itemView.context.packageName
        )
        val imgDrawable = ContextCompat.getDrawable(holder.itemView.context, imgResourceId)
        holder.imageView.setImageDrawable(imgDrawable)

holder.itemView.setOnClickListener {
    val intent= Intent(context, YogaDetails::class.java)
    intent.putExtra("title",item.title)
    intent.putExtra("image",item.img)
    intent.putExtra("desc",item.desc)
    intent.putExtra("kruti",item.kruti)
    intent.putExtra("laabh",item.laabh)
    intent.putExtra("savadh",item.savadh)
    context.startActivity(intent)
}


    }

    override fun getItemCount(): Int {
        return yogaItems.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tvtitle)
        val imageView: ImageView = itemView.findViewById(R.id.ivyoga)

        // Define other views here...
    }
}
