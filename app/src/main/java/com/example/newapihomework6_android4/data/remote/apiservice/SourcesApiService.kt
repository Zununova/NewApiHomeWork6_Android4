package com.example.newapihomework6_android4.data.remote.apiservice

import com.example.newapihomework6_android4.data.models.source.SourcesModel
import com.example.newapihomework6_android4.data.models.SourcesResponse
import retrofit2.Response
import retrofit2.http.GET

interface SourcesApiService {

    @GET("top-headlines/sources")
    suspend fun fetchSources(
    ): Response<SourcesResponse<SourcesModel>>
}