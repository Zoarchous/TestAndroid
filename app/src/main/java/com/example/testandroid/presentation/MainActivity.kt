package com.example.testandroid.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.imagesList.observe(this){
            recyclerViewAdapter.submitList(it)
        }
        val addButton = findViewById<Button>(R.id.add_image_button)

        addButton.setOnClickListener {
            val galeryIntent
        }

    }
    private fun setupRecyclerView() {
        val rvImageList = findViewById<RecyclerView>(R.id.images_recycler_view)
        with(rvImageList){
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }
}