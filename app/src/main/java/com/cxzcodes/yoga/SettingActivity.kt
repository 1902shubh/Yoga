package com.cxzcodes.yoga

import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.cxzcodes.helper.Utils.modeKey
import com.cxzcodes.helper.Utils.sharedPrefName
import com.cxzcodes.yoga.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    lateinit var binding:ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
         val sharedPrefs = getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
        val savedMode = sharedPrefs.getInt(modeKey, AppCompatDelegate.MODE_NIGHT_UNSPECIFIED)
        AppCompatDelegate.setDefaultNightMode(savedMode)

        binding.cvlitemode.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("डार्क मोड")
            dialog.setMessage("डार्क मोड को चालू और बंद करने के लिए UI रीस्टार्ट की आवश्यकता होती है। क्या आप जारी रखना चाहते हैं?")
            dialog.setPositiveButton(android.R.string.yes) { _, _ ->
                val currentNightMode = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
                val newMode = if (currentNightMode == Configuration.UI_MODE_NIGHT_NO) {
                    AppCompatDelegate.MODE_NIGHT_YES
                } else {
                    AppCompatDelegate.MODE_NIGHT_NO
                }

                 val editor = sharedPrefs.edit()
                editor.putInt(modeKey, newMode)
                editor.apply()

                 AppCompatDelegate.setDefaultNightMode(newMode)
                recreate()
            }

            dialog.setNegativeButton(android.R.string.no) { _, _ ->
            }

            val alertDialog = dialog.create()
            alertDialog.show()
        }
        binding.ivback.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
        binding.cvshareapp.setOnClickListener {
            val appLink = "https://play.google.com/store/apps/details?id=com.papayacoders.yoga"

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this app!")
            intent.putExtra(Intent.EXTRA_TEXT, "I found this amazing app!\n$appLink")

            startActivity(Intent.createChooser(intent, "Share via"))

        }
        binding.cvrate.setOnClickListener { val appPackageName = "com.papayacoders.yoga"

            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName"))
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                 val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName"))
                startActivity(intent)
            } }
    }
}