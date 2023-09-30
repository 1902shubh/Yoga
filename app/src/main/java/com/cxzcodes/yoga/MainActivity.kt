package com.cxzcodes.yoga

//import com.cxzcodes.DataBase.DatabaseHelper
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.cxzcodes.Data.ItemSlide
import com.cxzcodes.Interface.YogaDao
import com.cxzcodes.adapter.ItemSlideAdapter
import com.cxzcodes.Data.YogaModel
import com.cxzcodes.RoomDB.AppDatabase
import com.cxzcodes.bannerad.BannerAdManager
import com.cxzcodes.helper.SQLiteDBHelper
import com.cxzcodes.helper.Utils.a_schedule
import com.cxzcodes.helper.Utils.suryaatisatar
import com.cxzcodes.helper.Utils.yoga
import com.cxzcodes.yoga.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var yogaDao: YogaDao

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sliderecycler()

        onbtnclick()

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "yoga.db")
            .build()
        yogaDao = db.yogaDao()

        BannerAdManager.loadBannerAd(binding.adView)
        BannerAdManager.banneradloded(this)
        getData()
        compareAndSaveMatchingTitles()

    }

    fun compareAndSaveMatchingTitles() {
        for (scheduleA in a_schedule) {
            for (yoga in yoga) {
                if (scheduleA.title == yoga.title) {
                    // Create a YogaModel object and add it to suryaatisatar
                    val matchingYoga = YogaModel(
                        title = scheduleA.title,
                        img = yoga.img,
                        kruti = yoga.kruti,
                        laabh = yoga.laabh,
                        savadh = yoga.savadh,
                        desc = yoga.desc,
                        category = yoga.category
                    )
                    suryaatisatar.add(matchingYoga)
                }
            }
//            d("CHAGAN", suryaatisatar.toString())
        }
    }

    override fun onBackPressed() {
             val dialog = AlertDialog.Builder(this)
            dialog.setTitle(R.string.app_name)
            dialog.setMessage("क्या आप एप्लिकेशन को बंद करना चाहते हैं?")
            dialog.setPositiveButton(android.R.string.yes) { _, _ ->
                finish()
            }

            dialog.setNegativeButton(android.R.string.no) { _, _ ->
            }

            val alertDialog = dialog.create()
            alertDialog.show()

    }

    private fun onbtnclick() {
        binding.cvsurya.setOnClickListener {
            val intent = Intent(this, YogaList::class.java)
            intent.putExtra("surya", "1")
            startActivity(intent)
        }
        binding.cvpranayam.setOnClickListener {
            val pranayam = Intent(this, YogaList::class.java)
            pranayam.putExtra("pranayam", "1")
            startActivity(pranayam)
        }
        binding.cvmudra.setOnClickListener {
            val intent = Intent(this, YogaList::class.java)
            intent.putExtra("mudra", "1")
            startActivity(intent)
        }
        binding.cvmusic.setOnClickListener {
            startActivity(Intent(this, MusicActivity::class.java))
        }
        binding.cvyogasan.setOnClickListener {
            startActivity(Intent(this, YogaActivity::class.java))
        }
        binding.cvbmi.setOnClickListener {
            startActivity(Intent(this, BMICalculator::class.java))
        }
        binding.setting.setOnClickListener {
            startActivity(Intent(this, SettingActivity::class.java))
        }

    }

    private fun getData() {
        val dbHelper = SQLiteDBHelper(this, "yog.sqlite")

        dbHelper.copyDatabaseFromAssets(this)

        val data = dbHelper.readDataFromSQLite()

// Handle the retrieved data as needed
//        for (item in data) {
//            Log.d("SQLiteData", "Data: $item")
//        }

        for (item in a_schedule) {
//            Log.d("SQLiteData ", "Surya Data: $item")

        }

    }


    private fun sliderecycler() {
        val items = listOf(
            ItemSlide(R.drawable.startingyoga, "शुरुआती स्तर"),
            ItemSlide(R.drawable.mediumyoga, "मध्यवर्ती स्तर"),
            ItemSlide(R.drawable.hardyoga, "उन्नत स्तर"),


            )

        val adapter = ItemSlideAdapter(items, this)
        binding.recyclerviewslide.adapter = adapter
        binding.recyclerviewslide.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

}