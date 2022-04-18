package com.example.mymovieinfo.dao

import retrofit2.Call
import com.example.mymovieinfo.dto.Movie
import retrofit2.http.GET

interface IMovieDAO {

    @GET("/b/6227c3b9a703bb674925773a")
    fun getAllMovies() : Call<ArrayList<Movie>>
}