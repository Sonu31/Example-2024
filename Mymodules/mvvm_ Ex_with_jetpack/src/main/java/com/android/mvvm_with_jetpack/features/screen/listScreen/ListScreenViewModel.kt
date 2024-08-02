package com.android.mvvm_with_jetpack.features.screen.listScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.mvvm_with_jetpack.data.model.Article
import com.android.mvvm_with_jetpack.data.model.MyModel
import com.android.mvvm_with_jetpack.data.repo.Repository
import kotlinx.coroutines.launch

class ListScreenViewModel() : ViewModel() {

    private val _articles = mutableStateOf<List<Article>>(emptyList())
    val articles: State<List<Article>> = _articles


//    private var _mydata = MutableLiveData<MyModel>()
//    val mynewlist:LiveData<MyModel> get() = _mydata

    init {
        viewModelScope.launch {
            var response = Repository.getPost()
            if (response != null) {
                _articles.value = response
                println("Data Testing ListViewmode ${response}")
            }

        }

    }


}