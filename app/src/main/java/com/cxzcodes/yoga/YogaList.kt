package com.cxzcodes.yoga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.cxzcodes.adapter.YogaAdapter
import com.cxzcodes.bannerad.BannerAdManager
import com.cxzcodes.helper.Utils
import com.cxzcodes.helper.Utils.mudraData
import com.cxzcodes.helper.Utils.pranayamData
import com.cxzcodes.helper.Utils.suryaData
import com.cxzcodes.yoga.databinding.ActivityYogaListBinding

class YogaList : AppCompatActivity() {
    lateinit var binding: ActivityYogaListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityYogaListBinding.inflate(layoutInflater)
        Utils.loadLocale(this)

        setContentView(binding.root)
        BannerAdManager.loadBannerAd(binding.adView)
        BannerAdManager.banneradloded(this)
        fetchdata()
        binding.ivback.setOnClickListener {
            finish()        }
//        val adapter = YogaAdapter(suryaData,this)
//        binding.recyclerview.adapter = adapter
//        binding.recyclerview.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun fetchdata() {
        val surya=intent.getStringExtra("surya")
        val pranayam=intent.getStringExtra("pranayam")
        val mudra=intent.getStringExtra("mudra")
        d("CHAGAN",surya.toString())
        if (surya.toString()=="1"){
            val adapter = YogaAdapter(suryaData,this)
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }else if (pranayam.toString()=="1"){
            val adapter = YogaAdapter(pranayamData,this)
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }else if (mudra.toString()=="1"){
            val adapter = YogaAdapter(mudraData,this)
            binding.recyclerview.adapter = adapter
            binding.recyclerview.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        }
    }
}