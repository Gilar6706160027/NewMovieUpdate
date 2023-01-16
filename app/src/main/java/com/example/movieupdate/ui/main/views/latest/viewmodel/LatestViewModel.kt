package com.example.movieupdate.ui.main.views.latest.viewmodel

import androidx.lifecycle.liveData
import com.example.movieupdate.network.repository.IMovieDBRepository
import com.example.movieupdate.base.BaseViewModel

class LatestViewModel(private val repository: IMovieDBRepository) : BaseViewModel() {
    fun getLatestMovie() = liveData {
        emit(repository.getLatestMovie())
    }
}