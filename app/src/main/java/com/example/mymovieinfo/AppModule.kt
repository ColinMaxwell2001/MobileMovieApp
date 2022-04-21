package com.example.mymovieinfo


import com.example.mymovieinfo.service.IMovieService
import com.example.mymovieinfo.service.MovieService
import com.example.mymovieinfo.ui.main.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule = module {
    //viewModel { MainViewModel(get()) }
    viewModel { ApplicationViewModel(androidApplication())}
    single<MovieService> { MovieService() }
}