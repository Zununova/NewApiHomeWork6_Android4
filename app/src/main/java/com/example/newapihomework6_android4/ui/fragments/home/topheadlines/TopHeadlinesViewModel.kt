package com.example.newapihomework6_android4.ui.fragments.home.topheadlines

import com.example.newapihomework6_android4.base.BaseViewModel
import com.example.newapihomework6_android4.data.repositories.TopHeadlinesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopHeadlinesViewModel @Inject constructor(private val repository: TopHeadlinesRepository) :
    BaseViewModel() {

    fun fetchTopHeadlines() = repository.fetchTopHeadlines()
}