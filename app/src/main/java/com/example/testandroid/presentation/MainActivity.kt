package com.example.testandroid.presentation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.example.testandroid.R
import com.example.testandroid.databinding.ActivityMainBinding
import com.example.testandroid.domain.image.ImageItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        setupViewModel()
        viewModel.imagesList.observe(this) {
            recyclerViewAdapter.submitList(it)
            Log.d("!!List", it.toString())
        }

        binding.addImageButton.setOnClickListener {
            saveNames()
            val galleryIntent = Intent(
                Intent.ACTION_PICK,
                MediaStore.Images.Media.INTERNAL_CONTENT_URI
            )

            startActivityForResult(galleryIntent, REQUEST_CODE)
        }
    }

    private fun setupRecyclerView() {
        with(binding.imagesRecyclerView) {
            recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity)
            adapter = recyclerViewAdapter
        }
        setupClickListener()
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
        scope.launch {
            viewModel.setNames(binding.sectionNameEditText, binding.locationNameEditText)
        }
    }

    private fun saveNames(){
        scope.launch {
            val sectionName = binding.sectionNameEditText.text.toString()
            val locationName = binding.locationNameEditText.text.toString()
            viewModel.insertSectionName(sectionName)
            viewModel.insertLocationName(locationName)
        }
    }
    private fun setupClickListener() {
        recyclerViewAdapter.onClickListener = {
            supportFragmentManager.beginTransaction().run {
                val fragment = ImageFragment.setPhoto(it.photo)
                binding.mainLayout.visibility = View.GONE
                replace(R.id.container, fragment)
                addToBackStack(null)
                commit()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.mainLayout.visibility = View.VISIBLE
    }

}