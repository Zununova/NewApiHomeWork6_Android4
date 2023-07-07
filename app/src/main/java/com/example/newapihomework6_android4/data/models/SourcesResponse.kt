package com.example.newapihomework6_android4.data.models

import com.google.gson.annotations.SerializedName

data class SourcesResponse<T>(

    @SerializedName("status")
    val status: String,

    @SerializedName("sources")
    val sources: List<T>,
)


