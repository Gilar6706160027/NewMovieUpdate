package com.example.movieupdate.ui.main.views.popular.viewmodel

import androidx.lifecycle.liveData
import com.example.movieupdate.network.repository.IMovieDBRepository
import com.example.movieupdate.base.BaseViewModel

class PopularViewModel(private val repository: IMovieDBRepository) : BaseViewModel() {
    fun getPopularMovies(page: Int) = liveData {
        emit(repository.getPopularMovies(page = page))
    }
}