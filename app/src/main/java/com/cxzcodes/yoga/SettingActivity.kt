package com.cxzcodes.yoga

import android.R
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.cxzcodes.helper.Utils
import com.cxzcodes.helper.Utils.loadLocale
import com.cxzcodes.helper.Utils.newLanguageCode_PREF_KEY
import com.cxzcodes.helper.Utils.modeKey
import com.cxzcodes.helper.Utils.saveLancodeToSharedPreferences
import com.cxzcodes.helper.Utils.setLocale
import com.cxzcodes.helper.Utils.sharedPrefName
import com.cxzcodes.yoga.databinding.ActivitySettingBinding
import java.util.Locale

class SettingActivity : AppCompatActivity() {
    lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        loadLocale(this)

        setContentView(binding.root)
        val sharedPrefs = getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
        val savedMode = sharedPrefs.getInt(modeKey, AppCompatDelegate.MODE_NIGHT_UNSPECIFIED)

        AppCompatDelegate.setDefaultNightMode(savedMode)



        binding.cvnewLanguageCode.setOnClickListener { changenewLanguageCode() }
        binding.cvlitemode.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle(com.cxzcodes.yoga.R.string.dark_mode)
            dialog.setMessage(com.cxzcodes.yoga.R.string.dark_dialog)
            dialog.setPositiveButton(android.R.string.yes) { _, _ ->
                val currentNightMode =
                    resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
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
            finish()
        }
        binding.cvshareapp.setOnClickListener {
            val appLink = "https://play.google.com/store/apps/details?id=com.papayacoders.yoga"

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Check out this app!")
            intent.putExtra(Intent.EXTRA_TEXT, "I found this amazing app!\n$appLink")

            startActivity(Intent.createChooser(intent, "Share via"))

        }
        binding.cvrate.setOnClickListener {
            val appPackageName = "com.papayacoders.yoga"

            try {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName"))
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                )
                startActivity(intent)
            }
        }
    }

//    fun setLocale(newLanguageCodeCode: String) {
//
//        val locale = Locale(newLanguageCodeCode)
//        Locale.setDefault(locale)
//        val config = Configuration(this.resources.configuration)
//        config.setLocale(locale)
//        this.resources.updateConfiguration(config, this.resources.displayMetrics)
//        val shared: SharedPreferences.Editor = getSharedPreferences("language", MODE_PRIVATE).edit()
//        shared.putString("app_lang", newLanguageCodeCode)
//        shared.apply()
//    }
//
//    fun loadLocale() {
//        val shared: SharedPreferences = getSharedPreferences("language", MODE_PRIVATE)
//        val language = shared.getString("app_lang", "")
//        setLocale(language.toString())
//    }

    private fun changenewLanguageCode() {
        val newLanguageCodes = arrayOf("Hindi", "English")

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Choose newLanguageCode")
        val sharedPrefs = getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
        val selectednewLanguageCode = sharedPrefs.getString(newLanguageCode_PREF_KEY, "hi")


        val checkedItem = if (selectednewLanguageCode == "hi") {
            0

        } else {
            1
        }

        dialog.setSingleChoiceItems(
            newLanguageCodes,
            checkedItem,
            DialogInterface.OnClickListener { dialogInterface, i ->
                val newnewLanguageCodeCode = if (i == 0) "hi" else "en"
                saveSelectednewLanguageCode(newnewLanguageCodeCode)
                setLocale(newnewLanguageCodeCode,this)
                recreateApp()
                saveLancodeToSharedPreferences(this,newnewLanguageCodeCode)
            })

        dialog.create()
        dialog.show()
    }

    private fun saveSelectednewLanguageCode(newLanguageCodeCode: String) {
        val sharedPrefs = getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putString(newLanguageCode_PREF_KEY, newLanguageCodeCode)
        editor.apply()
    }

    private fun recreateApp() {
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }


}