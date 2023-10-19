package com.cxzcodes.helper

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import com.cxzcodes.Data.Schedule
import com.cxzcodes.Data.SuryaModel
import com.cxzcodes.Data.YogaModel
import java.util.Locale

object Utils {
    val yoga = mutableListOf<YogaModel>()

    val suryaatisatar = mutableListOf<YogaModel>()
    val suryaData = mutableListOf<SuryaModel>()
    val pranayamData = mutableListOf<SuryaModel>()
    val mudraData = mutableListOf<SuryaModel>()


    val a_schedule = mutableListOf<Schedule>()
    val b_schedule = mutableListOf<Schedule>()
    val i_schedule = mutableListOf<Schedule>()


      val sharedPrefName = "MyAppPrefs"
      val modeKey = "ThemeMode"
      var language = "hindi"
      var lancode = ""
      val newLanguageCode_PREF_KEY = "selected_newLanguageCode"

    fun setLocale(newLanguageCodeCode: String, context: Context) {
        lancode=newLanguageCodeCode
        val locale = Locale(newLanguageCodeCode)
        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        config.setLocale(locale)
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
        val shared: SharedPreferences.Editor = context.getSharedPreferences("language", Context.MODE_PRIVATE).edit()
        shared.putString("app_lang", newLanguageCodeCode)
        shared.apply()
    }
    fun loadLocale(context: Context) {
        val shared: SharedPreferences = context.getSharedPreferences(
            "language",
            AppCompatActivity.MODE_PRIVATE
        )
        val language = shared.getString("app_lang", "")
        setLocale(language.toString(), context)
    }


    fun saveLancodeToSharedPreferences(context: Context, value: String) {
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString(newLanguageCode_PREF_KEY, value)
        editor.apply()
         lancode = value
    }
 
}