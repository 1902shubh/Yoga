package com.cxzcodes.adapter

import android.content.Context
import android.content.Intent
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.Data.YogaModel
import com.cxzcodes.helper.Utils
import com.cxzcodes.yoga.R
import com.cxzcodes.yoga.YogaDetails

class YogasanAdapter(private val yogaItems: MutableList<YogaModel>,val context:Context) : RecyclerView.Adapter<YogasanAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = yogaItems[position]
if (Utils.language=="hindi"){
    holder.titleTextView.text = item.title
    d("TITLE",item.title.toString())

}else{
    holder.titleTextView.text = item.titleEng
    d("TITLE",item.titleEng.toString())

}
         val imgResourceId = holder.itemView.context.resources.getIdentifier(
            item.img, "drawable", holder.itemView.context.packageName
        )
        val imgDrawable = ContextCompat.getDrawable(holder.itemView.context, imgResourceId)
        holder.imageView.setImageDrawable(imgDrawable)

holder.itemView.setOnClickListener {
    if (Utils.language=="hindi"){
        val intent= Intent(context, YogaDetails::class.java)
        intent.putExtra("title",item.title)
        intent.putExtra("image",item.img)
        intent.putExtra("desc",item.desc)
        intent.putExtra("kruti",item.kruti)
        intent.putExtra("laabh",item.laabh)
        intent.putExtra("savadh",item.savadh)
        intent.putExtra("viddhi","िधि :")
        intent.putExtra("labh","लाभ")
        intent.putExtra("savdhani","सावधानी")
        context.startActivity(intent)
    }else{
        val intent= Intent(context, YogaDetails::class.java)
        intent.putExtra("title",item.titleEng)
        intent.putExtra("image",item.img)
        intent.putExtra("desc",item.descEng)
        intent.putExtra("kruti",item.krutii)
        intent.putExtra("laabh",item.laabhEng)
        intent.putExtra("viddhi","Method")
        intent.putExtra("labh","Profit")
        intent.putExtra("savdhani","Careful")
        intent.putExtra("savadh",item.savadhEng)
        context.startActivity(intent)
    }

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
