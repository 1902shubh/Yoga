package com.cxzcodes.yoga

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log.d
import androidx.appcompat.app.AppCompatDelegate
import com.cxzcodes.helper.Utils.lancode
import com.cxzcodes.helper.Utils.language
import com.cxzcodes.helper.Utils.loadLocale
import com.cxzcodes.helper.Utils.modeKey
import com.cxzcodes.helper.Utils.sharedPrefName


class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val sharedPrefs = getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
        val savedMode = sharedPrefs.getInt(modeKey, AppCompatDelegate.MODE_NIGHT_UNSPECIFIED)
loadLocale(this)
         AppCompatDelegate.setDefaultNightMode(savedMode)
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1200)
if (language==""){
    language="english"
}else if (lancode=="hi")
 {
     language="hindi"
 }else{
     language="english"

 }
      }
}