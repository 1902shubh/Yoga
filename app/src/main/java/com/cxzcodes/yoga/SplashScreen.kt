package com.cxzcodes.yoga

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatDelegate
import com.cxzcodes.helper.Utils.modeKey
import com.cxzcodes.helper.Utils.sharedPrefName

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val sharedPrefs = getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
        val savedMode = sharedPrefs.getInt(modeKey, AppCompatDelegate.MODE_NIGHT_UNSPECIFIED)

         AppCompatDelegate.setDefaultNightMode(savedMode)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }
}