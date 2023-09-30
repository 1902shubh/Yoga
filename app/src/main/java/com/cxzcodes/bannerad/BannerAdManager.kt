package com.cxzcodes.bannerad

import android.content.Context
import android.util.Log.d
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds

object BannerAdManager {
    private var mAdView: AdView? = null

    fun initialize(context: Context) {
        MobileAds.initialize(context)
    }

    fun loadBannerAd(adView: AdView) {
        mAdView = adView
        val adRequest = AdRequest.Builder().build()
        mAdView?.loadAd(adRequest)
    }
fun banneradloded(context: Context){
    mAdView?.adListener = object: AdListener() {
        override fun onAdClicked() {
            // Code to be executed when the user clicks on an ad.
        }

        override fun onAdClosed() {
            // Code to be executed when the user is about to return
            // to the app after tapping on an ad.
        }

        override fun onAdFailedToLoad(adError : LoadAdError) {
            // Code to be executed when an ad request fails.
        }

        override fun onAdImpression() {
            // Code to be executed when an impression is recorded
            // for an ad.
        }

        override fun onAdLoaded() {
            d("ADLODED","Banner ad loded")
            // Code to be executed when an ad finishes loading.
        }

        override fun onAdOpened() {
            // Code to be executed when an ad opens an overlay that
            // covers the screen.
        }
    }
}


    fun destroyBannerAd() {
        mAdView?.destroy()
    }


}
