package com.cxzcodes.helper

import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.cxzcodes.Data.SuryaModel
import com.cxzcodes.Data.YogaModel
import com.cxzcodes.helper.Utils.suryaData
import java.io.FileOutputStream
import java.io.IOException

class SQLiteDBHelper(context: Context, private val dbName: String) :
    SQLiteOpenHelper(context, dbName, null, 1) {

    private val TAG = SQLiteDBHelper::class.java.simpleName

    companion object {
        private const val DB_NAME = "yog.sqlite"
        private const val DB_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {}

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {}
    fun copyDatabaseFromAssets(context: Context) {
        val inputFileName = "yog.sqlite"
        val outputFilePath = context.getDatabasePath(DB_NAME)

        try {
            val inputStream = context.assets.open(inputFileName)
            val outputStream = FileOutputStream(outputFilePath)

            val buffer = ByteArray(1024)
            var length: Int
            while ((inputStream.read(buffer)) > 0) {
                outputStream.write(buffer)
            }

            outputStream.flush()
            outputStream.close()
            inputStream.close()
        } catch (e: IOException) {
            Log.e(TAG, "Error copying database from assets: ${e.message}")
        }
    }
    fun readDataFromSQLite(): List<YogaModel> {
        val data = mutableListOf<YogaModel>()
        val query = "SELECT * FROM yoga"
        val suryaQuery = "SELECT * FROM surya"

        val db: SQLiteDatabase = this.readableDatabase

        var cursor: Cursor? = null
        try {
            cursor = db.rawQuery(query, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        data.add(
                            YogaModel(
                                cursor.getString(cursor.getColumnIndex("title")),
                                cursor.getString(cursor.getColumnIndex("img")),
                                cursor.getString(cursor.getColumnIndex("kruti")),
                                cursor.getString(cursor.getColumnIndex("laabh")),
                                cursor.getString(cursor.getColumnIndex("savadh")),
                                cursor.getString(cursor.getColumnIndex("desc")),
                                cursor.getString(cursor.getColumnIndex("category")),
                            )
                        )
                    } while (cursor.moveToNext())
                }
            }
        } catch (e: SQLException) {
            Log.e(TAG, "Error reading data from SQLite database: ${e.message}")
        } finally {
            cursor?.close()
         //   db.close()
        }


        try {
            cursor = db.rawQuery(suryaQuery, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        suryaData.add(
                            SuryaModel(
                                cursor.getString(cursor.getColumnIndex("title")),
                                cursor.getString(cursor.getColumnIndex("img")),
                                cursor.getString(cursor.getColumnIndex("kruti")),
                                cursor.getString(cursor.getColumnIndex("laabh")),
                                cursor.getString(cursor.getColumnIndex("savadh")),
                                cursor.getString(cursor.getColumnIndex("desc"))
                            )
                        )
                    } while (cursor.moveToNext())
                }
            }
        } catch (e: SQLException) {
            Log.e(TAG, "Error reading data from SQLite database: ${e.message}")
        } finally {
            cursor?.close()
            db.close()
        }







        return data
    }
}