package com.example.newsapps.api

import com.android.mvvmexample.data.model.MyModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface EventService {
    @GET("v2/top-headlines?sources=techcrunch&apiKey=97fa2fde6b7545539409853ea7503f8b")
    suspend fun getEvents() : Response<MyModel>
}