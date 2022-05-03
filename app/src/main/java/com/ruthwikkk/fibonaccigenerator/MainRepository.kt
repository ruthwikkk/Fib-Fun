package com.ruthwikkk.fibonaccigenerator

import android.content.Context
import com.ruthwikkk.audifytask.database.AppDatabase
import com.ruthwikkk.fibonaccigenerator.database.FibNumber

class MainRepository(val context: Context) {
    val database = AppDatabase.getDatabase(context)

    fun getAllNumbers() = database.mainDao().getNumbers()

    fun insertNumber(number: FibNumber){
        database.mainDao().insertNumber(number)
    }
}