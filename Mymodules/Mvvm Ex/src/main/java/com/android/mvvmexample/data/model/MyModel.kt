package com.android.mvvmexample.data.model

data class MyModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)