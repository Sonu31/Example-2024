package com.android.mvvmexample.features.screen.listScreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.mvvmexample.data.repo.Repository
import com.android.mvvmexample.databinding.ActivityMainBinding
import com.android.mvvmexample.features.screen.details_Screen.DetailsActivity
import com.android.mvvmexample.features.screen.listScreen.adapter.AdapterOnItemClickListener
import com.android.mvvmexample.features.screen.listScreen.adapter.NewsListAdapter
import com.android.mvvmexample.features.screen.listScreen.viewModel.MainViewModel
import com.android.mvvmexample.features.screen.listScreen.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
        var _binding: ActivityMainBinding?=null
            val binding   get() = _binding!!
            override fun onDestroy() {
                super.onDestroy()
                _binding= null
            }

    lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val repository = Repository
        val viewmodeFactory = MainViewModelFactory(repository)

        viewModel = ViewModelProvider(this,viewmodeFactory)[MainViewModel::class.java]

        viewModel.getDAta()
        viewModel.listMutableLiveDAta.observe(this, Observer {
            var newsListAdapter = NewsListAdapter(it,this,object : AdapterOnItemClickListener{
                override fun onClick(position: Int) {
                var intent = Intent(this@MainActivity,DetailsActivity::class.java)
                  intent.putExtra("URL_IMAGE",it[position].urlToImage)
                  intent.putExtra("TITLE",it[position].title)
                  intent.putExtra("DESC",it[position].description)
                    startActivity(intent)
                }

            })

            binding.rv.adapter = newsListAdapter
            println("Data Testing test"+it)

        })

        println("Data Testing")
    }
}