package com.example.mymovieinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieinfo.dto.Movie
import com.example.mymovieinfo.service.MovieService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // Implements the movie service fetch movies list to create a live data list of the movies
    var movies : MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
   private var movieService : MovieService = MovieService()
    fun fetchCountries() {
        viewModelScope.launch{
            var innerMovies = movieService.fetchMovies()
            movies.postValue(innerMovies)
        }

    }

}