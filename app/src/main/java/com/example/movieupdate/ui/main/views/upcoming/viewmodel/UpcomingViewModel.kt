package com.example.movieupdate.ui.main.views.upcoming.viewmodel

import androidx.lifecycle.liveData
import com.example.movieupdate.network.repository.IMovieDBRepository
import com.example.movieupdate.base.BaseViewModel

class UpcomingViewModel(private val repository: IMovieDBRepository) : BaseViewModel() {
    fun getUpcomingMovies(page: Int) = liveData {
        emit(repository.getUpcomingMovies(page = page))
    }
}