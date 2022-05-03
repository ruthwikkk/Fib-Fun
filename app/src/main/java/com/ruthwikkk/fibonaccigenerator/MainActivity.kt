package com.ruthwikkk.fibonaccigenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()
    var adapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initObservers()
    }

    fun initViews(){
        adapter = MainAdapter()
        val rvNumbers = findViewById<RecyclerView>(R.id.rv_numbers)
        rvNumbers.adapter = adapter

        findViewById<FloatingActionButton>(R.id.btn_generate).setOnClickListener {
            viewModel.generateFibonacciNumber()
        }
    }

    fun initObservers(){
        viewModel.getNumbers().observe(this) {
            adapter?.submitList(it)
        }
    }
}