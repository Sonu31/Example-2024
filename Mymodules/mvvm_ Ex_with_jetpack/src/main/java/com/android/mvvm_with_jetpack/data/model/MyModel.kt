package com.android.mvvm_with_jetpack.data.model

data class MyModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)