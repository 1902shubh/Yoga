package com.cxzcodes.yoga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cxzcodes.adapter.YogasanAdapter
import com.cxzcodes.Data.YogaModel
import com.cxzcodes.bannerad.BannerAdManager
import com.cxzcodes.helper.Utils
import com.cxzcodes.yoga.databinding.ActivityYogaBinding

class YogaActivity : AppCompatActivity() {
    lateinit var binding: ActivityYogaBinding
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYogaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchdata("a")
         BannerAdManager.loadBannerAd(binding.adView)
         BannerAdManager.banneradloded(this)
         binding.first.setOnClickListener {
            binding.first.setBackgroundResource(R.color.appcolor)
            binding.secound.setBackgroundResource(R.color.buttoncolor)
            binding.third.setBackgroundResource(R.color.buttoncolor)
            fetchdata("a")
        }
         binding.ivback.setOnClickListener {
             startActivity(Intent(this,MainActivity::class.java))
         }
        binding.secound.setOnClickListener {
            binding.first.setBackgroundResource(R.color.buttoncolor)
            binding.secound.setBackgroundResource(R.color.appcolor)
            binding.third.setBackgroundResource(R.color.buttoncolor)
            fetchdata("b")
        }
        binding.third.setOnClickListener {
            binding.first.setBackgroundResource(R.color.buttoncolor)
            binding.secound.setBackgroundResource(R.color.buttoncolor)
            binding.third.setBackgroundResource(R.color.appcolor)
            fetchdata("i")
        }

    }

    fun fetchdata(category: String) {

        val filteredYogaList = Utils.yoga.filter { it.category == category }

        val adapter = YogasanAdapter(filteredYogaList as MutableList<YogaModel>, this)

        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}