package com.example.newapihomework6_android4.data.repositories

import com.example.newapihomework6_android4.base.BaseRepository
import com.example.newapihomework6_android4.data.remote.apiservice.SourcesApiService
import javax.inject.Inject

class SourcesRepository @Inject constructor(private val service: SourcesApiService) :
    BaseRepository() {

    fun fetchSources() = doRequest {
        service.fetchSources()
    }
}