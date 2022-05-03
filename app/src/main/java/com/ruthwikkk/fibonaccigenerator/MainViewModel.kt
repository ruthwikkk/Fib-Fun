package com.ruthwikkk.fibonaccigenerator

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ruthwikkk.fibonaccigenerator.database.FibNumber
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MainRepository(application)

    fun generateFibonacciNumber() = viewModelScope.launch(Dispatchers.IO) {
        val number = Utils.generateFibonacci()
        val fibNumber = FibNumber(0, number.toString(), System.currentTimeMillis())
        insertNumber(fibNumber)
    }

    private fun insertNumber(number: FibNumber) {
        repository.insertNumber(number)
    }

    fun getNumbers() = repository.getAllNumbers()
}