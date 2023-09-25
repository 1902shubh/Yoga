package com.cxzcodes.RoomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cxzcodes.Data.Yoga
import com.cxzcodes.Interface.YogaDao

@Database(entities = [Yoga::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun yogaDao(): YogaDao

 }