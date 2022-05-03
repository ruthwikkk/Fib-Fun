package com.ruthwikkk.fibonaccigenerator

import android.annotation.SuppressLint
import java.math.BigInteger
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun generateFibonacci(): BigInteger {
        val k = (1..100).random()
        var num1 = BigInteger("0")
        var num2 = BigInteger("1")
        var fib: BigInteger

        for(i in 0 until k){
            fib = num1 + num2
            num1 = num2
            num2 = fib
        }

        return num1
    }

    @SuppressLint("SimpleDateFormat")
    fun toPrettyTime(timeStamp: Long): String{
        return try {
            val fmt: DateFormat = SimpleDateFormat("dd MMM yyyy hh:mm a")
            val date = Date(timeStamp)
            val prettyDate = fmt.format(date)
            prettyDate
        }catch (e: Exception){
            e.printStackTrace()
            ""
        }
    }
}