package com.ruthwikkk.fibonaccigenerator.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNumber(number: FibNumber)

    @Query("SELECT * FROM number ORDER BY timeStamp DESC")
    fun getNumbers(): LiveData<List<FibNumber>>
}