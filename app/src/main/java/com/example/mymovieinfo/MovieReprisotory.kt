package com.example.mymovieinfo

import com.example.mymovieinfo.service.MovieService

class MovieReprisotory(private val api: MovieService) {

    suspend fun getAllMovies (movieName : String ) = api.fetchMovies(movieName)

}
