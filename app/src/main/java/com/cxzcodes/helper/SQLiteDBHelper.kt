package com.cxzcodes.helper

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.cxzcodes.Data.Schedule
import com.cxzcodes.Data.SuryaModel
import com.cxzcodes.Data.YogaModel
import com.cxzcodes.helper.Utils.a_schedule
import com.cxzcodes.helper.Utils.b_schedule
import com.cxzcodes.helper.Utils.i_schedule
import com.cxzcodes.helper.Utils.mudraData
import com.cxzcodes.helper.Utils.pranayamData
import com.cxzcodes.helper.Utils.suryaData
import com.cxzcodes.helper.Utils.yoga
import java.io.FileOutputStream
import java.io.IOException

class SQLiteDBHelper(context: Context, private val dbName: String) :
    SQLiteOpenHelper(context, dbName, null, 1) {

    private val TAG = SQLiteDBHelper::class.java.simpleName

    companion object {
        const val DB_NAME = "yog.sqlite"
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
            while (inputStream.read(buffer).also { length = it } > 0) {
                outputStream.write(buffer, 0, length)
            }

            outputStream.flush()
            outputStream.close()
            inputStream.close()
        } catch (e: IOException) {
            Log.e(TAG, "Error copying database from assets: ${e.message}")
        }
    }

    @SuppressLint("Range")
    fun readDataFromSQLite(): List<YogaModel> {
        val yogaquery = "SELECT * FROM yoga"
        val suryaQuery = "SELECT * FROM surya"
        val pranayamQuery = "SELECT * FROM pranayam"
        val mudraQuery = "SELECT * FROM mudra"
        val a_scheduleQuery = "SELECT * FROM a_schedule"
        val b_scheduleQuery = "SELECT * FROM b_schedule"
        val i_scheduleQuery = "SELECT * FROM i_schedule"

        val db: SQLiteDatabase = this.readableDatabase

        var cursor: Cursor? = null

//      Get data from yoga table
        try {
            cursor = db.rawQuery(yogaquery, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        yoga.add(
                            YogaModel(
                                cursor.getString(cursor.getColumnIndex("title")),
                                cursor.getString(cursor.getColumnIndex("img")),
                                cursor.getString(cursor.getColumnIndex("kruti")),
                                cursor.getString(cursor.getColumnIndex("laabh")),
                                cursor.getString(cursor.getColumnIndex("savadh")),
                                cursor.getString(cursor.getColumnIndex("desc")),
                                cursor.getString(cursor.getColumnIndex("category")),
                                cursor.getString(cursor.getColumnIndex("titleEng")),
                                cursor.getString(cursor.getColumnIndex("krutii")),
                                cursor.getString(cursor.getColumnIndex("laabhEng")),
                                cursor.getString(cursor.getColumnIndex("savadhEng")),
                                cursor.getString(cursor.getColumnIndex("descEng")),

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


//      Get data from surya table


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
                                cursor.getString(cursor.getColumnIndex("desc")),
                                cursor.getString(cursor.getColumnIndex("titleEng")),
                                cursor.getString(cursor.getColumnIndex("krutii")),
                                cursor.getString(cursor.getColumnIndex("laabhEng")),
                                cursor.getString(cursor.getColumnIndex("savadhEng")),
                                cursor.getString(cursor.getColumnIndex("descEng")),
                            )
                        )
                    } while (cursor.moveToNext())
                }
            }
        } catch (e: SQLException) {
            Log.e(TAG, "Error reading data from SQLite database: ${e.message}")
        } finally {
            cursor?.close()
//            db.close()
        }

        //      Get data from pranayam table

        try {
            cursor = db.rawQuery(pranayamQuery, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        pranayamData.add(
                            SuryaModel(
                                cursor.getString(cursor.getColumnIndex("title")),
                                cursor.getString(cursor.getColumnIndex("img")),
                                cursor.getString(cursor.getColumnIndex("kruti")),
                                cursor.getString(cursor.getColumnIndex("laabh")),
                                cursor.getString(cursor.getColumnIndex("savadh")),
                                cursor.getString(cursor.getColumnIndex("desc")),
                                cursor.getString(cursor.getColumnIndex("titleEng")),
                                cursor.getString(cursor.getColumnIndex("krutii")),
                                cursor.getString(cursor.getColumnIndex("laabhEng")),
                                cursor.getString(cursor.getColumnIndex("savadhEng")),
                                cursor.getString(cursor.getColumnIndex("descEng")),

                            )
                        )
                    } while (cursor.moveToNext())
                }
            }
        } catch (e: SQLException) {
            Log.e(TAG, "Error reading data from SQLite database: ${e.message}")
        } finally {
            cursor?.close()
//            db.close()
        }
        //      Get data from mudra table

        try {
            cursor = db.rawQuery(mudraQuery, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        mudraData.add(
                            SuryaModel(
                                cursor.getString(cursor.getColumnIndex("title")),
                                cursor.getString(cursor.getColumnIndex("img")),
                                cursor.getString(cursor.getColumnIndex("kruti")),
                                cursor.getString(cursor.getColumnIndex("laabh")),
                                cursor.getString(cursor.getColumnIndex("savadh")),
                                cursor.getString(cursor.getColumnIndex("desc")),
                                cursor.getString(cursor.getColumnIndex("titleEng")),
                                cursor.getString(cursor.getColumnIndex("krutii")),
                                cursor.getString(cursor.getColumnIndex("laabhEng")),
                                cursor.getString(cursor.getColumnIndex("savadhEng")),
                                cursor.getString(cursor.getColumnIndex("descEng")),
                             )
                        )
                    } while (cursor.moveToNext())
                }
            }
        } catch (e: SQLException) {
            Log.e(TAG, "Error reading data from SQLite database: ${e.message}")
        } finally {
            cursor?.close()
//            db.close()
        }
        //      Get data from a_schedule table

        try {
            cursor = db.rawQuery(a_scheduleQuery, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        a_schedule.add(
                            Schedule(
                                cursor.getString(cursor.getColumnIndex("title")),
                                cursor.getString(cursor.getColumnIndex("days")),
                                        cursor.getString(cursor.getColumnIndex("titleEng"))

                            )
                        )
                    } while (cursor.moveToNext())
                }
            }
        } catch (e: SQLException) {
            Log.e(TAG, "Error reading data from SQLite database: ${e.message}")
        } finally {
            cursor?.close()
//            db.close()
        }
        //      Get data from b_schedule table

        try {
            cursor = db.rawQuery(b_scheduleQuery, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        b_schedule.add(
                            Schedule(
                                cursor.getString(cursor.getColumnIndex("title")),
                                cursor.getString(cursor.getColumnIndex("days")),
                                        cursor.getString(cursor.getColumnIndex("titleEng"))

                            )
                        )
                    } while (cursor.moveToNext())
                }
            }
        } catch (e: SQLException) {
            Log.e(TAG, "Error reading data from SQLite database: ${e.message}")
        } finally {
            cursor?.close()
//            db.close()
        }
        try {
            cursor = db.rawQuery(i_scheduleQuery, null)
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        i_schedule.add(
                            Schedule(

                                cursor.getString(cursor.getColumnIndex("title")),
                                cursor.getString(cursor.getColumnIndex("days")),
                                        cursor.getString(cursor.getColumnIndex("titleEng"))

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







        return yoga
    }
}