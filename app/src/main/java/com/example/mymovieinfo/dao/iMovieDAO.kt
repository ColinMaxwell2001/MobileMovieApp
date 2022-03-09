package com.example.mymovieinfo.dao

import com.example.mymovieinfo.dto.Movie
import retrofit2.Call
import retrofit2.http.GET

interface iMovieDAO {
    @GET()
    fun getAllMovies() : Call<List<Movie>>
}