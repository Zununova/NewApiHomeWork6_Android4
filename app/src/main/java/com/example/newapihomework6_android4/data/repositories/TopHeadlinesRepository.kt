package com.example.newapihomework6_android4.data.repositories

import com.example.newapihomework6_android4.base.BaseRepository
import com.example.newapihomework6_android4.data.remote.apiservice.TopHeadlinesApiService
import javax.inject.Inject

class TopHeadlinesRepository @Inject constructor(private val service: TopHeadlinesApiService) :
    BaseRepository() {

    fun fetchTopHeadlines() = doRequest {
        service.fetchTopHeadlines()
    }
}