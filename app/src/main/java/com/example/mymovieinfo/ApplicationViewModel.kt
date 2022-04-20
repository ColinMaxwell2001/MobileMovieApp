package com.example.mymovieinfo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.mymovieinfo.service.MovieService
import com.example.mymovieinfo.ui.main.LocationLiveData

class ApplicationViewModel(application: Application) : AndroidViewModel(application) {
    private var _movieService: MovieService = MovieService(application)
    private val locationLiveData = LocationLiveData(application)
    fun getLocationLiveData() = locationLiveData
    fun startLocationUpdates(){
        locationLiveData.startLocationUpdates()
    }

}