package com.example.newsapps.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Url

object RetrofitHelper {
    private const val BASE_URL = "https://newsapi.org/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: EventService by lazy {

        retrofit.create(EventService::class.java)
    }
}