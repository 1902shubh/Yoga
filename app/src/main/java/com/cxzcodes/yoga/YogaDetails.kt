package com.cxzcodes.yoga

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import com.cxzcodes.bannerad.BannerAdManager
import com.cxzcodes.helper.Utils
import com.cxzcodes.yoga.databinding.ActivityYogaDetailsBinding

class YogaDetails : AppCompatActivity() {
    lateinit var binding: ActivityYogaDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityYogaDetailsBinding.inflate(layoutInflater)
        Utils.loadLocale(this)

        setContentView(binding.root)
        val title = intent.getStringExtra("title")
        val image = intent.getStringExtra("image")
        val desc = intent.getStringExtra("desc")
        val kruti = intent.getStringExtra("kruti")
        val laabh = intent.getStringExtra("laabh")
        val savadh = intent.getStringExtra("savadh")
        val viddhi = intent.getStringExtra("viddhi")
        val labh = intent.getStringExtra("labh")
        val savdhani = intent.getStringExtra("savdhani")
        binding.viddhi.setText(viddhi.toString())
        binding.labh.setText(labh.toString())
        binding.savdhani.setText(savdhani.toString())
        if (image != null) {
            val imgResourceId = resources.getIdentifier(image, "drawable", packageName)
            val imgDrawable = ContextCompat.getDrawable(this, imgResourceId)
            binding.ivyoga.setImageDrawable(imgDrawable)
        }
        binding.ivback.setOnClickListener {
            finish()
        }
        BannerAdManager.loadBannerAd(binding.adView)
        BannerAdManager.banneradloded(this)
        binding.tvtitle.setText(title.toString())
        if (kruti != "not available") {
            binding.kruti.text = kruti.toString()
        }
        if (laabh != "not available") {
            binding.laabh.visibility = View.VISIBLE
            binding.labh.visibility = View.VISIBLE
            binding.laabh.text = laabh.toString()
        } else {
            binding.laabh.visibility = View.GONE
            binding.labh.visibility = View.GONE
        }
        if (savadh != "not available") {
            binding.svaadh.visibility = View.VISIBLE
            binding.savdhani.visibility = View.VISIBLE
            binding.svaadh.text = laabh.toString()
        } else {
            binding.savdhani.visibility = View.GONE
            binding.svaadh.visibility = View.GONE
        }
        if (desc != "not available") {
            binding.desc.visibility = View.VISIBLE
            binding.desc.text = desc.toString()
        } else {
            binding.desc.visibility = View.GONE
        }
    }
}
