package com.cxzcodes.bannerad

import android.app.Application

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        BannerAdManager.initialize(this)
    }
}