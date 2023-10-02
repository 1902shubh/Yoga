package com.cxzcodes.yoga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cxzcodes.adapter.YogasanAdapter
import com.cxzcodes.Data.YogaModel
import com.cxzcodes.bannerad.BannerAdManager
import com.cxzcodes.helper.Utils
import com.cxzcodes.helper.Utils.language
import com.cxzcodes.yoga.databinding.ActivityYogaBinding

class YogaActivity : AppCompatActivity() {
    lateinit var binding: ActivityYogaBinding
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYogaBinding.inflate(layoutInflater)
         Utils.loadLocale(this)

         setContentView(binding.root)
         if (language=="hindi"){
             binding.firsttv.setText("प्रारंभिक श्रेणी")
             binding.secounttv.setText("मध्यवर्ती श्रेण")
             binding.thirdtv.setText("उन्नत श्रेणी")
             binding.tvtitle.setText("पंडित दीनदयाल उपाध्याय योग संस्थान")
         }else
         {
             binding.firsttv.setText("Primary Category")
             binding.secounttv.setText("Intermediate Category")
             binding.thirdtv.setText("Advanced Category")
             binding.tvtitle.setText("Pandit deen dayal upadhyay yoga sansthan ")
         }



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
             finish()
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