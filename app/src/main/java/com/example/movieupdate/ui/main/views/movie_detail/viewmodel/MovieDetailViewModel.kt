package com.example.movieupdate.ui.main.views.movie_detail.viewmodel

import androidx.lifecycle.liveData
import com.example.movieupdate.network.repository.IMovieDBRepository
import com.example.movieupdate.base.BaseViewModel

class MovieDetailViewModel(private val repository: IMovieDBRepository) : BaseViewModel() {
    fun getMovieById(movieID: String) = liveData {
        emit(repository.getMovieById(movieID))
    }

    fun getCast(movieID: String) = liveData {
        emit(repository.getCast(movieID))
    }

    fun getCrew(movieID: String) = liveData {
        emit(repository.getCrew(movieID))
    }

    fun getReviewById(movieID: String) = liveData {
        emit(repository.getReview(movieID))
    }
}