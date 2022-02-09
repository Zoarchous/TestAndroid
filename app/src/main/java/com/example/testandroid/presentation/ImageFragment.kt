package com.example.testandroid.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testandroid.R
import com.example.testandroid.databinding.FragmentImageBinding
import com.squareup.picasso.Picasso

private const val PHOTO = "photo"
class ImageFragment : Fragment() {
    private lateinit var binding: FragmentImageBinding
    private val photo: String by lazy { requireArguments().getString(PHOTO, "") }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageBinding.inflate(inflater)

        Picasso.get()
            .load(photo)
            .into(binding.fullscreenImage)

        binding.backButton.setOnClickListener {
            val activity = activity as MainActivity
            activity.supportFragmentManager.beginTransaction().remove(this).commit()
            activity.onBackPressed()
        }

        return binding.root
    }


    companion object{
        fun setPhoto(photo: String) = ImageFragment().apply {
            arguments = Bundle().apply {
                putString(PHOTO, photo)
            }
        }
    }

}