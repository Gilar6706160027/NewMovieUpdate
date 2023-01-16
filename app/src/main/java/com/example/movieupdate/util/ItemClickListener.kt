package com.example.movieupdate.util

import android.view.View

interface ItemClickListener<T> {
    fun onItemClicked(v: View, data: T)
}