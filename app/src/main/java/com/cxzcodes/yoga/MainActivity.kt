package com.cxzcodes.yoga

//import com.cxzcodes.DataBase.DatabaseHelper
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.sqlite.db.SimpleSQLiteQuery
import com.cxzcodes.Data.ItemSlide
import com.cxzcodes.Interface.YogaDao
import com.cxzcodes.Model.ItemSlideAdapter
import com.cxzcodes.RoomDB.AppDatabase
import com.cxzcodes.helper.SQLiteDBHelper
import com.cxzcodes.helper.Utils.suryaData
import com.cxzcodes.yoga.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var yogaDao: YogaDao

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sliderecycler()

//    savedatainroomdb()

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "yoga.db")
            .build()
        yogaDao = db.yogaDao()


        getData()


    }

    private fun getData() {
        val dbHelper = SQLiteDBHelper(this, "yog.sqlite")

        dbHelper.copyDatabaseFromAssets(this)

        val data = dbHelper.readDataFromSQLite()

// Handle the retrieved data as needed
        for (item in data) {
            Log.d("SQLiteData", "Data: $item")




        }

        for (item in suryaData) {
            Log.d("SQLiteData ", "Surya Data: $item")

        }

    }

    private fun savedatainroomdb() {
        val inputStream = this.assets.open("yog.sqlite")

        try {
            // Open the Room database and start a transaction
            val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "yoga.db")
                .build()

            val transactionRunner = CoroutineScope(Dispatchers.IO)

            transactionRunner.launch {
                db.beginTransaction()
                try {
                    while (inputStream.read() != -1) {
                        // Read and execute SQL statements from the input stream
                        val sqlQuery = inputStream.bufferedReader().readLine()
                        val query = SimpleSQLiteQuery(sqlQuery)
                        db.yogaDao().query(query)
                    }
                    db.setTransactionSuccessful()
                } finally {
                    db.endTransaction()
                    db.close()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            inputStream?.close()
        }
    }

    private fun sliderecycler() {
        val items = listOf(
            ItemSlide(R.drawable.yogawallpaper, "Item 1"),
            ItemSlide(R.drawable.yogawallpaper, "Item 2"),
            ItemSlide(R.drawable.yogawallpaper, "Item 3"),


            )

        val adapter = ItemSlideAdapter(items)
        binding.recyclerviewslide.adapter = adapter
        binding.recyclerviewslide.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}