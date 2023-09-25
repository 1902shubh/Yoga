package com.cxzcodes.yoga

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import androidx.sqlite.db.SimpleSQLiteQuery
import com.cxzcodes.Data.ItemSlide
import com.cxzcodes.Data.Yoga
//import com.cxzcodes.DataBase.DatabaseHelper
import com.cxzcodes.DataBase.DatabaseInitializer
import com.cxzcodes.Interface.YogaDao
import com.cxzcodes.Model.ItemSlideAdapter
import com.cxzcodes.RoomDB.AppDatabase
import com.cxzcodes.yoga.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.IOException


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var yogaDao: YogaDao
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sliderecycler()

    savedatainroomdb()

        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "yoga.db")
            .build()
        yogaDao = db.yogaDao()


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