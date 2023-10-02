package com.cxzcodes.manager

import android.app.LocaleManager
import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import com.cxzcodes.helper.Utils.newLanguageCode_PREF_KEY
import com.cxzcodes.helper.Utils.sharedPrefName
import java.util.Locale

open class BaseActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        val sharedPrefs = newBase.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
        val selectednewLanguageCode = sharedPrefs.getString(newLanguageCode_PREF_KEY, "default")
        val locale = Locale(selectednewLanguageCode)
        Locale.setDefault(locale)
        val config = Configuration(newBase.resources.configuration)
        config.setLocale(locale)
        super.attachBaseContext(newBase.createConfigurationContext(config))
    }

}
