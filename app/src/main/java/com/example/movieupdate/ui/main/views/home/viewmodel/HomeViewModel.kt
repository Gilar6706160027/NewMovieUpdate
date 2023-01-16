package com.example.movieupdate.ui.main.views.home.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.movieupdate.base.BaseViewModel

class HomeViewModel : BaseViewModel() {
    var userName = MutableLiveData<String>()
}