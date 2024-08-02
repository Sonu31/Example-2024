package com.android.mvvmexample.data.repo

import com.android.mvvmexample.data.model.MyModel
import com.example.newsapps.api.RetrofitHelper
import retrofit2.Call
import retrofit2.Response


object Repository {

    suspend fun getPost(): Response<MyModel> = RetrofitHelper.api.getEvents()

}