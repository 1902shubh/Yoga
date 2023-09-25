package com.cxzcodes.yoga.SplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cxzcodes.yoga.MainActivity
import com.cxzcodes.yoga.R
import com.cxzcodes.yoga.databinding.ActivityStartScreenBinding

class StartScreen : AppCompatActivity() {
    lateinit var binding:ActivityStartScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStartScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnstart.setOnClickListener { startActivity(Intent(this,MainActivity::class.java)) }
    }
}