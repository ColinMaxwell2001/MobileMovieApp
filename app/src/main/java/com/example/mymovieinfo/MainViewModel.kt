package com.example.mymovieinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieinfo.dto.Movie
import com.example.mymovieinfo.service.MovieService
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // Implements the movie service fetch movies list to create a live data list of the movies
    var movies : MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    private var movieService : MovieService = MovieService()

    private lateinit var firestore: FirebaseFirestore

    init{
        listenToSpecimens()
    }

    /*
    This will hear any from firestore
     */
    private fun listenToSpecimens() {
        firestore.collection("specimens")
    }

    fun fetchCountries() {
        viewModelScope.launch{
            var innerMovies = movieService.fetchMovies()
            movies.postValue(innerMovies)
        }
    }

}