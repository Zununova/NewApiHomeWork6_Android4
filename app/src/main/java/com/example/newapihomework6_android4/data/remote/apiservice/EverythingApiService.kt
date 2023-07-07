package com.example.newapihomework6_android4.data.remote.apiservice

import com.example.newapihomework6_android4.data.models.NewsResponse
import com.example.newapihomework6_android4.data.models.everything.EverythingModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EverythingApiService {

    @GET("everything")
    suspend fun fetchEverything(
        @Query("q") q: String = "+bitcoin",
    ): Response<NewsResponse<EverythingModel>>
}