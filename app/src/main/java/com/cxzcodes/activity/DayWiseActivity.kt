package com.cxzcodes.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.adapter.DayAdapter
import com.cxzcodes.helper.Utils
import com.cxzcodes.yoga.R

class DayWiseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_wise)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val layoutManager = GridLayoutManager(this,2)
        val adapter = DayAdapter( Utils.a_schedule,this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}