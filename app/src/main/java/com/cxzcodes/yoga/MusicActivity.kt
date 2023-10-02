package com.cxzcodes.yoga

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.cxzcodes.bannerad.BannerAdManager
import com.cxzcodes.helper.SQLiteDBHelper
import com.cxzcodes.helper.Utils
import com.cxzcodes.yoga.databinding.ActivityMusicBinding

class MusicActivity : AppCompatActivity() {
    lateinit var binding: ActivityMusicBinding
    private lateinit var mediaPlayer: MediaPlayer
    private var playbackCount = 0
    private val maxPlaybackCount = 108
    private val audioFiles = arrayOf(R.raw.om, R.raw.gaytrimantra)
    private var currentTrackIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMusicBinding.inflate(layoutInflater)
        Utils.loadLocale(this)

        setContentView(binding.root)
        updateTrackInfo()
        BannerAdManager.loadBannerAd(binding.adView)
        BannerAdManager.banneradloded(this)


        mediaPlayer = MediaPlayer.create(this, audioFiles[currentTrackIndex])
        if (mediaPlayer.isPlaying) {
            binding.btnpausee.visibility = View.VISIBLE
            binding.btnplay.visibility = View.GONE
        }
        binding.ivback.setOnClickListener {
            finish()
         }
        binding.btnplay.setOnClickListener {
            playAudio()
            binding.btnpausee.visibility = View.VISIBLE
            binding.btnplay.visibility = View.GONE
        }
        binding.btnpausee.setOnClickListener {
            pauseAudio()
            binding.btnpausee.visibility = View.GONE
            binding.btnplay.visibility = View.VISIBLE
        }

        binding.btnnext.setOnClickListener {
            playNextTrack()
        }

        binding.btnprevious.setOnClickListener {
            playPreviousTrack()
        }
    }

    private fun playAudio() {
        mediaPlayer.setOnCompletionListener { mp ->
            if (playbackCount < maxPlaybackCount) {
                playbackCount++
                mp.start()
            } else {
                playbackCount = 0
                mp.release()
            }
        }


            mediaPlayer.start()


    }

    private fun pauseAudio() {
        mediaPlayer.pause()
    }

    private fun playNextTrack() {
        binding.btnpausee.visibility = View.GONE
        binding.btnplay.visibility = View.VISIBLE
        binding.ivthumbnail.setImageResource(R.drawable.gaytrimantraimage)
        if (currentTrackIndex < audioFiles.size - 1) {
            currentTrackIndex++
            mediaPlayer.release()
            mediaPlayer = MediaPlayer.create(this, audioFiles[currentTrackIndex])
            updateTrackInfo()
        }
    }

    private fun playPreviousTrack() {
        binding.btnpausee.visibility = View.GONE
        binding.btnplay.visibility = View.VISIBLE
        binding.ivthumbnail.setImageResource(R.drawable.ommantra)

        if (currentTrackIndex > 0) {
            currentTrackIndex--
            mediaPlayer.release()
            mediaPlayer = MediaPlayer.create(this, audioFiles[currentTrackIndex])
            updateTrackInfo()
        }
    }

    private fun updateTrackInfo() {
        val trackName = resources.getResourceEntryName(audioFiles[currentTrackIndex])
        binding.tvtitle.text = " $trackName"
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}
