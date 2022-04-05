package com.example.mymovieinfo.dao

import retrofit2.Call
import com.example.mymovieinfo.dto.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface IMovieDAO {

    @GET("/b/6227c3b9a703bb674925773a")
    fun getAllMovies() : Call<ArrayList<Movie>>

    @GET("/b/6227c3b9a703bb674925773a")
    fun getMovies(@Query("Combined_Name") movieName:String): Call<ArrayList<Movie>>
}