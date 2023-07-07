package com.example.newapihomework6_android4.data.remote.apiservice

import com.example.newapihomework6_android4.data.models.NewsResponse
import com.example.newapihomework6_android4.data.models.everything.EverythingModel
import com.example.newapihomework6_android4.data.models.topheadlines.TopHeadlinesModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TopHeadlinesApiService {

    @GET("top-headlines")
    suspend fun fetchTopHeadlines(
        @Query("country") country: String = "ru",
    ): Response<NewsResponse<TopHeadlinesModel>>
}