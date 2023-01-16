package com.example.movieupdate.model

data class MovieWrapper(
    val page: Int,
    val totalResults: Int,
    val totalPages: Int,
    val results: List<Movie>?,
)