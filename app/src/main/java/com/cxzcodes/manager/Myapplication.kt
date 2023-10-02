package com.cxzcodes.manager

import android.app.Application
import com.cxzcodes.helper.Utils

class Myapplication:Application() {
    override fun onCreate() {
        super.onCreate()
Utils.loadLocale(this)
    }
}