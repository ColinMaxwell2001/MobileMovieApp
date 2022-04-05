package com.example.mymovieinfo.dao

import androidx.lifecycle.LiveData
import com.example.mymovieinfo.dto.Movie
import retrofit2.http.Query


interface ILocalMovieDAO {

    fun getAllMovies() : LiveData<List<Movie>>

    fun insertAll(movies: ArrayList<Movie>)

    fun delete(movie: Movie)

    fun save(movie: Movie)
}