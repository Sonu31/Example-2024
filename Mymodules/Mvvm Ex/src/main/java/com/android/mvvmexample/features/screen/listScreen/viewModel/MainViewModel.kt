package com.android.mvvmexample.features.screen.listScreen.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.mvvmexample.data.model.Article
import com.android.mvvmexample.data.model.MyModel
import com.android.mvvmexample.data.repo.Repository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {


    val listMutableLiveDAta : MutableLiveData<List<Article>> = MutableLiveData()
    
    fun getDAta(){
        viewModelScope.launch {
            val  responce = repository.getPost()
            println("Data Testing 23  ${responce.body()?.articles}")
            listMutableLiveDAta.value = responce.body()?.articles
        }
    }


}