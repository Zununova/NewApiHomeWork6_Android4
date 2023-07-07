package com.example.newapihomework6_android4.ui.fragments.home.sources

import com.example.newapihomework6_android4.base.BaseViewModel
import com.example.newapihomework6_android4.data.repositories.SourcesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SourcesViewModel @Inject constructor(private val repository: SourcesRepository) :
    BaseViewModel() {

    fun fetchSources() = repository.fetchSources()
}