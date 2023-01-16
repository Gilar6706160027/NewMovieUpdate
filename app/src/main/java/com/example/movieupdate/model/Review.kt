package com.example.movieupdate.model

data class Review(
    val author: String,
    val author_details: AuthorDetail,
    val content: String,
    val created_at: String,
    val id: String,
    val update_at: String,
    val url: String,
)