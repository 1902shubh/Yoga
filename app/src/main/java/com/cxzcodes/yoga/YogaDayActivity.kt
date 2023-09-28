package com.cxzcodes.yoga

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.adapter.DayAdapter
import com.cxzcodes.helper.Utils.a_schedule

class YogaDayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yoga_day)


        val type = intent.getIntExtra("type", 0)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)
        val layoutManager = GridLayoutManager(this, 2)
        val adapter = DayAdapter( this, type)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}
