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
import com.cxzcodes.Data.SuryaModel
import com.cxzcodes.yoga.R
import com.cxzcodes.yoga.YogaDetails

class YogaAdapter(private val suryaList: MutableList<SuryaModel>,var context:Context) :
    RecyclerView.Adapter<YogaAdapter.SuryaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuryaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return SuryaViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuryaViewHolder, position: Int) {
        val suryaModel = suryaList[position]
        holder.titleTextView.text = suryaModel.title
//        holder.krutiTextView.text = suryaModel.kruti

        // Load the image based on the img string (e.g., "s1")
        val imgResourceId = holder.itemView.context.resources.getIdentifier(
            suryaModel.img, "drawable", holder.itemView.context.packageName
        )
        val imgDrawable = ContextCompat.getDrawable(holder.itemView.context, imgResourceId)
        holder.imageView.setImageDrawable(imgDrawable)
        holder.itemView.setOnClickListener {
val intent=Intent(context,YogaDetails::class.java)
            intent.putExtra("title",suryaModel.title)
            intent.putExtra("image",suryaModel.img)
            intent.putExtra("desc",suryaModel.desc)
            intent.putExtra("kruti",suryaModel.kruti)
            intent.putExtra("laabh",suryaModel.laabh)
            intent.putExtra("savadh",suryaModel.savadh)
            context.startActivity(intent)
          }
    }

    override fun getItemCount(): Int {
        return suryaList.size
    }

    inner class SuryaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tvtitle)
        val imageView: ImageView = itemView.findViewById(R.id.ivyoga)

//        val krutiTextView: TextView = itemView.findViewById(R.id.krutiTextView)

    }
}
