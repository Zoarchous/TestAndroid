package com.example.testandroid.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.DialogFragment
import com.example.testandroid.R
import com.example.testandroid.databinding.FragmentImageBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

private const val PHOTO = "photo"
class ImageFragment : DialogFragment() {

    private lateinit var binding: FragmentImageBinding
    private val photo: String by lazy { requireArguments().getString(PHOTO, "") }
    private var toolbar: androidx.appcompat.widget.Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.AppTheme_FullScreenDialog)
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null){
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window?.setLayout(width,height)
            dialog.window?.setWindowAnimations(R.style.AppTheme_Slide)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentImageBinding.inflate(inflater)
        toolbar = binding.toolbar
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get()
            .load(photo)
            .into(binding.fullscreenImage, object: Callback {
                override fun onSuccess() {
                    binding.progressBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                    Log.d("!!!", "$e")
                }

            })
        toolbar!!.setNavigationOnClickListener { v: View? -> dismiss()
        activity?.onBackPressed()
        }
    }



    companion object{
        const val TAG = "dialog"
        fun setPhoto(photo: String) = ImageFragment().apply {
            arguments = Bundle().apply {
                putString(PHOTO, photo)
            }
        }
    }


}