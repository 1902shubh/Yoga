package com.cxzcodes.Interface

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import com.cxzcodes.Data.Yoga

@Dao
interface YogaDao {
    @Insert
    suspend fun insert(yourEntity: Yoga)

    @RawQuery
    fun query(query: SupportSQLiteQuery): List<Yoga>
}

