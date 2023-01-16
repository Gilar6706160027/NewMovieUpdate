package com.example.movieupdate.ui.launcher.dependency_injection

import com.example.movieupdate.ui.launcher.viewmodel.LauncherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val launcherModule = module {
    viewModel { LauncherViewModel(get()) }
}