package com.ruthwikkk.fibonaccigenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private var adapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initObservers()
    }

    private fun initViews(){
        adapter = MainAdapter()
        val rvNumbers = findViewById<RecyclerView>(R.id.rv_numbers)
        rvNumbers.adapter = adapter

        findViewById<FloatingActionButton>(R.id.btn_generate).setOnClickListener {
            viewModel.generateFibonacciNumber()
        }
    }

    private fun initObservers(){
        viewModel.getNumbers().observe(this) {
            adapter?.submitList(it)
        }
    }
}