package com.cxzcodes.bannerad

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.cxzcodes.helper.Utils.newLanguageCode_PREF_KEY
import com.cxzcodes.helper.Utils.sharedPrefName
import java.util.Locale

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        BannerAdManager.initialize(this)
     }


}