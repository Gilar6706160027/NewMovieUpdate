package com.example.movieupdate.ui.main.views.top_rated.viewmodel

import androidx.lifecycle.liveData
import com.example.movieupdate.network.repository.IMovieDBRepository
import com.example.movieupdate.base.BaseViewModel

class TopRatedViewModel(private val repository: IMovieDBRepository) : BaseViewModel() {
    fun getTopRatedMovies(page: Int) = liveData {
        emit(repository.getTopRatedMovies(page = page))
    }
}