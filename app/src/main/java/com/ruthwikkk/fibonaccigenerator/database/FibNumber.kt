package com.ruthwikkk.fibonaccigenerator.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number")
data class FibNumber(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var number: String,

    var timeStamp: Long
)
