package com.cxzcodes.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.activity.DayWiseActivity
import com.cxzcodes.helper.Utils
import com.cxzcodes.helper.Utils.language
import com.cxzcodes.yoga.R
import com.cxzcodes.yoga.YogaDayActivity
import com.google.android.material.card.MaterialCardView

class DayAdapter(val context: Context, val type: Int) :
    RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    private val dayNamesInHindi = listOf(
        "पहला दिन",
        "दूसरा दिन",
        "तीसरा दिन",
        "चौथा दिन",
        "पांचवा दिन",
        "छठा दिन",
        "सातवा दिन",
        "आठवां दिन",
        "नौवां दिन",
        "दसवां दिन",
        "ग्यारहवां दिन",
        "बारहवां दिन",
        "तेरहवां दिन",
        "चौदहवां दिन",
        "पंद्रहवां दिन",
        "सोलहवां दिन",
        "सत्रहवां दिन",
        "अठारहवां दिन",
//        "उन्नीसवां दिन",
//        "बीसवां दिन",
//        "इक्कीसवां दिन",
//        "बाईसवां दिन",
//        "तेईसवां दिन",
//        "चौबीसवां दिन",
//        "पच्चीसवां दिन",
//        "छब्बीसवां दिन",
//        "सत्ताईसवां दिन",
//        "अट्ठासीसवां दिन",
//        "उनतीसवां दिन",
//        "तीसवां दिन"
    )
    private val dayNamesInEnglish = listOf(
        "First Day",
        "Second day",
        "Third day",
        "Fourth Day",
        "Fifth Day",
        "Sixth Day",
        "Seventh Day",
        "Eighth Day",
        "Ninth day",
        "tenth day",
        "Eleventh Day",
        "Twelfth Day",
        "Thirteenth Day",
        "Fourteenth day",
        "Fifteenth day",
        "Sixteenth day",
        "Seventeenth day",
        "Eightteenth day",
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.day_layout, parent, false)
        return DayViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(position)

        holder.itemView.setOnClickListener {
            val inte = Intent(context, DayWiseActivity::class.java)
            inte.putExtra("type", type)
            inte.putExtra("day", position)
            context.startActivity(inte)
//            if ((position + 1) % 4 == 0) {
//                if (language=="hindi"){
//
//                    Toast.makeText(context, "आज विश्राम कीजिये", Toast.LENGTH_SHORT).show()
//                }else{
//                    Toast.makeText(context, "Today Rest", Toast.LENGTH_SHORT).show()
//
//                }
//            }else{
//                val inte = Intent(context, DayWiseActivity::class.java)
//                inte.putExtra("type", type)
//                inte.putExtra("day", position)
//                context.startActivity(inte)
//            }
        }
    }

    override fun getItemCount(): Int {
        return dayNamesInHindi.size
    }

    inner class DayViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dayNameTextView: TextView = itemView.findViewById(R.id.dayNameTextView)
        private val dayImageView: ImageView = itemView.findViewById(R.id.dayImageView)

        @SuppressLint("SuspiciousIndentation")
        fun bind(position: Int) {
            for (i in dayNamesInHindi[position])
            dayNameTextView.text = dayNamesInHindi[position]


            if (Utils.language=="hindi"){
                dayNameTextView.text = dayNamesInHindi[position]

            }else{
                dayNameTextView.text = dayNamesInEnglish[position]

            }

            dayImageView.visibility = View.GONE
            dayNameTextView.visibility = View.VISIBLE

//            if ((position + 1) % 4 == 0) {
//                dayImageView.visibility = View.VISIBLE
//                dayNameTextView.visibility = View.GONE
//                dayImageView.setImageResource(R.drawable.restday)
//            } else {
//                dayImageView.visibility = View.GONE
//                dayNameTextView.visibility = View.VISIBLE
//
//            }
        }
    }
}
