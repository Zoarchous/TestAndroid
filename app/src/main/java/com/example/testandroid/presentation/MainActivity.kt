package com.example.testandroid.presentation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.testandroid.R
import com.example.testandroid.data.localModel.AppDataBase
import com.example.testandroid.data.localModel.ImagesDao
import com.example.testandroid.domain.ImageItem
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URI
import java.util.jar.Manifest
import javax.inject.Inject

const val REQUEST_CODE = 100
const val REQUEST_PERMISSION_CODE = 33

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    @Inject lateinit var factory: MainViewModelFactory
    private var imageUri: Uri? = null
    val scope = CoroutineScope(Dispatchers.IO)
    private val permission = android.Manifest.permission.READ_EXTERNAL_STORAGE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        setupViewModel()
        viewModel.imagesList.observe(this) {
            recyclerViewAdapter.submitList(it)
            Log.d("!!List", it.toString())
        }
        val addButton = findViewById<ImageButton>(R.id.add_image_button)

        addButton.setOnClickListener {
            val galleryIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI
            )
            startActivityForResult(galleryIntent, REQUEST_CODE)
        }

    }

    private fun setupRecyclerView() {
        val rvImageList = findViewById<RecyclerView>(R.id.images_recycler_view)
        with(rvImageList) {
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            imageUri = data?.data
            val image = ImageItem(imageUri.toString())
            scope.launch {
                viewModel.addImageItem(image)
                Log.d("!!Image", image.toString())
            }
        }
    }

    private fun setupViewModel() {
        ActivityCompat.requestPermissions(this, arrayOf(permission), REQUEST_PERMISSION_CODE)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
    }
}