package com.example.movieupdate.ui.launcher.view

import android.os.Bundle
import com.example.movieupdate.databinding.ActivityLauncherBinding
import com.example.movieupdate.base.BaseActivity
import com.example.movieupdate.util.HOME_ACTIVITY_PACKAGE_PATH
import com.example.movieupdate.ui.launcher.viewmodel.LauncherViewModel

class LauncherActivity : BaseActivity<LauncherViewModel, ActivityLauncherBinding>() {

    override val binding: ActivityLauncherBinding by lazy {
        ActivityLauncherBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnClicks()
    }

    private fun setOnClicks() {
        binding.movieButton.setOnClickListener {
            startActivity(HOME_ACTIVITY_PACKAGE_PATH)
        }
    }
}