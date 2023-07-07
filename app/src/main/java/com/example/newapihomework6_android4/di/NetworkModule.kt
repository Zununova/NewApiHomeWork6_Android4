package com.example.newapihomework6_android4.di

import com.example.newapihomework6_android4.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofitClient() = RetrofitClient()

    @Singleton
    @Provides
    fun provideEverythingApiService(retrofitClient: RetrofitClient) = retrofitClient.provideEverythingApiService()

    @Singleton
    @Provides
    fun provideTopHeadlinesApiService(retrofitClient: RetrofitClient) = retrofitClient.provideTopHeadlinesApiService()

    @Singleton
    @Provides
    fun provideSourcesApiService(retrofitClient: RetrofitClient) = retrofitClient.provideSourcesApiService()

}