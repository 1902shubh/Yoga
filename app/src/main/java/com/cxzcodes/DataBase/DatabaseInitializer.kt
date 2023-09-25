package com.cxzcodes.DataBase

import android.content.Context
import androidx.room.Room
import com.cxzcodes.RoomDB.AppDatabase
import java.io.FileOutputStream
import java.io.IOException

class DatabaseInitializer private constructor() {
    companion object {
        private const val DB_NAME = "yog.sqlite"

        fun initialize(context: Context) {
            val dbFile = context.getDatabasePath(DB_NAME)

            if (!dbFile.exists()) {
                try {
                    val inputStream = context.assets.open(DB_NAME)
                    val outputStream = FileOutputStream(dbFile)

                    val buffer = ByteArray(1024)
                    var length: Int
                    while (inputStream.read(buffer).also { length = it } > 0) {
                        outputStream.write(buffer, 0, length)
                    }

                    outputStream.flush()
                    outputStream.close()
                    inputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }

        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, DB_NAME
            ).build()
        }
    }
}
