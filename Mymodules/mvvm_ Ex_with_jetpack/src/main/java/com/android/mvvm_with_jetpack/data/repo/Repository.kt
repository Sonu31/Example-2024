package com.android.mvvm_with_jetpack.data.repo

import com.android.mvvm_with_jetpack.data.model.MyModel
import com.android.mvvm_with_jetpack.data.api.RetrofitHelper
import com.android.mvvm_with_jetpack.data.model.Article
import retrofit2.Response


object Repository {

    suspend fun getPost(): List<Article>? = RetrofitHelper.api.getEvents().body()?.articles

}