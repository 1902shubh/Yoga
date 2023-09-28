package com.cxzcodes.yoga

//import com.cxzcodes.DataBase.DatabaseHelper
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.cxzcodes.Data.ItemSlide
import com.cxzcodes.Interface.YogaDao
import com.cxzcodes.adapter.ItemSlideAdapter
import com.cxzcodes.Data.YogaModel
import com.cxzcodes.RoomDB.AppDatabase
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


        getData()
compareAndSaveMatchingTitles()
        d("CHAGAN",a_schedule.toString())

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
            d("CHAGAN", suryaatisatar.toString())
        }
    }    private fun onbtnclick() {
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
            Log.d("SQLiteData ", "Surya Data: $item")

        }

    }


    private fun sliderecycler() {
        val items = listOf(
            ItemSlide(R.drawable.yogawallpaper, "Item 1"),
            ItemSlide(R.drawable.yogawallpaper, "Item 2"),
            ItemSlide(R.drawable.yogawallpaper, "Item 3"),


            )

        val adapter = ItemSlideAdapter(items,this)
        binding.recyclerviewslide.adapter = adapter
        binding.recyclerviewslide.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
}