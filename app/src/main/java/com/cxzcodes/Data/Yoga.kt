package com.cxzcodes.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "yoga")
data class Yoga(
    @PrimaryKey(autoGenerate = true)
    val id:Int,

    val title: String,
    val img: String,
    val kruti: String,
    val laabh: String,
    val savadh: String,
    val desc: String,
    val category: String
)

