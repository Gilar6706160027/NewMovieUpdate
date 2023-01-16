package com.example.movieupdate.model

data class ReviewWrapper(
    val id: Int,
    val page: Int,
    val results: List<Review>,
    val totalPages: Int,
    val totalResults: Int,
)