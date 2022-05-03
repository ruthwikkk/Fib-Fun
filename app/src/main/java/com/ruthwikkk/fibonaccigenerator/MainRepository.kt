package com.ruthwikkk.fibonaccigenerator

import android.content.Context
import com.ruthwikkk.fibonaccigenerator.database.AppDatabase
import com.ruthwikkk.fibonaccigenerator.database.FibNumber

class MainRepository(context: Context) {
    private val database = AppDatabase.getDatabase(context)

    fun getAllNumbers() = database.mainDao().getNumbers()

    fun insertNumber(number: FibNumber){
        database.mainDao().insertNumber(number)
    }
}