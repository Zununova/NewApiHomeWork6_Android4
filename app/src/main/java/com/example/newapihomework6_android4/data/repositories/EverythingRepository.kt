package com.example.newapihomework6_android4.data.repositories

import com.example.newapihomework6_android4.base.BaseRepository
import com.example.newapihomework6_android4.data.remote.apiservice.EverythingApiService
import javax.inject.Inject

class EverythingRepository @Inject constructor(private val service: EverythingApiService) :
    BaseRepository() {

    fun fetchEverything() = doRequest {
        service.fetchEverything()
    }
}