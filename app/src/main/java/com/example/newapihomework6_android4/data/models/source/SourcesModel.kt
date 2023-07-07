package com.example.newapihomework6_android4.data.models.source

import com.google.gson.annotations.SerializedName

data class SourcesModel(

    @SerializedName("id")
    var id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("url")
    val url: String,

    @SerializedName("category")
    val category: String,

    @SerializedName("general")
    val general: String
)
