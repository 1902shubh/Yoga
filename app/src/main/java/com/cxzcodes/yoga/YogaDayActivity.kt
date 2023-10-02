package com.cxzcodes.yoga

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.adapter.DayAdapter
import com.cxzcodes.adapter.DayAdapterTC
import com.cxzcodes.bannerad.BannerAdManager
import com.cxzcodes.helper.Utils
import com.cxzcodes.helper.Utils.a_schedule
import com.cxzcodes.yoga.databinding.ActivityYogaBinding
import com.cxzcodes.yoga.databinding.ActivityYogaDayBinding
import com.cxzcodes.yoga.databinding.ActivityYogaDetailsBinding

class YogaDayActivity : AppCompatActivity() {
    lateinit var binding: ActivityYogaDayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYogaDayBinding.inflate(layoutInflater)
        Utils.loadLocale(this)

        setContentView(binding.root)

        BannerAdManager.loadBannerAd(binding.adView)
        BannerAdManager.banneradloded(this)
        val type = intent.getIntExtra("type", 0)
         val recyclerView = binding.recyclerview
        val layoutManager = GridLayoutManager(this, 3)

        binding.ivback.setOnClickListener {
            finish()
        }
        recyclerView.layoutManager = layoutManager

        if (type == 2) {
            val adapter2 = DayAdapterTC(this, type)
            recyclerView.adapter = adapter2


        } else {
            val adapter = DayAdapter(this, type)
            recyclerView.adapter = adapter
        }
    }
}
