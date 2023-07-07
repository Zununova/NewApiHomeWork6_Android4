package com.example.newapihomework6_android4.data.models.everything

import com.example.newapihomework6_android4.data.models.source.SourcesModel
import com.google.gson.annotations.SerializedName

data class EverythingModel(

    @SerializedName("source")
    val source: SourcesModel,

    @SerializedName("author")
    val author: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("urlToImage")
    val urlToImage: String,

    @SerializedName("url")
    val url: String
)