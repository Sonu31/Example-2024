package com.android.mvvmexample.features.screen.details_Screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.mvvmexample.R
import com.android.mvvmexample.databinding.ActivityDetailsBinding
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {

lateinit    var imageUrl:String
lateinit    var tilte:String
lateinit    var desp:String


        var _binding: ActivityDetailsBinding?=null
            val binding   get() = _binding!!
            override fun onDestroy() {
                super.onDestroy()
                _binding= null
            }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    imageUrl=    intent.getStringExtra("URL_IMAGE").toString()
    title=     intent.getStringExtra("TITLE").toString()
   desp=    intent.getStringExtra("DESC").toString()


        Glide.with(this).load(imageUrl).into(binding.imageview)
        binding.tv1id.text = title
        binding.tv2id.text = desp


    }
}