package com.cxzcodes.yoga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.adapter.DayAdapter
import com.cxzcodes.helper.Utils.a_schedule

class YogaDayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga_day)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val layoutManager = GridLayoutManager(this,2)
        val adapter = DayAdapter( a_schedule,this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
    }
