package com.example.newapihomework6_android4.ui.fragments.home.everything

import com.example.newapihomework6_android4.base.BaseViewModel
import com.example.newapihomework6_android4.data.repositories.EverythingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingViewModel @Inject constructor(private val repository: EverythingRepository) :
    BaseViewModel() {

    fun fetchEverything() = repository.fetchEverything()
}