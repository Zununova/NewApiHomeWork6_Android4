package com.example.newapihomework6_android4.data.remote

import com.example.newapihomework6_android4.data.remote.apiservice.EverythingApiService
import com.example.newapihomework6_android4.data.remote.apiservice.SourcesApiService
import com.example.newapihomework6_android4.data.remote.apiservice.TopHeadlinesApiService
import com.example.newapihomework6_android4.data.remote.interseptors.ApiKeyInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor())
        .addInterceptor(ApiKeyInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun loggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideEverythingApiService(): EverythingApiService =
        retrofitClient.create(EverythingApiService::class.java)

    fun provideTopHeadlinesApiService(): TopHeadlinesApiService =
        retrofitClient.create(TopHeadlinesApiService::class.java)

    fun provideSourcesApiService(): SourcesApiService =
        retrofitClient.create(SourcesApiService::class.java)


}