package com.alexbirichevskiy.devlife

data class DataModel(
    val result: List<Item>,
    val totalCount: Int
)

data class Item(
    val author: String,
    val description: String,
    val gifURL: String,
    val previewURL: String
)
