package com.example.movieupdate.ui.main.views.now_playing.viewmodel

import androidx.lifecycle.liveData
import com.example.movieupdate.network.repository.IMovieDBRepository
import com.example.movieupdate.base.BaseViewModel

class NowPlayingViewModel(private val repository: IMovieDBRepository) : BaseViewModel() {
    fun getNowPlayingMovies(page: Int) = liveData {
        emit(repository.getNowPlayingMovies(page = page))
    }
}