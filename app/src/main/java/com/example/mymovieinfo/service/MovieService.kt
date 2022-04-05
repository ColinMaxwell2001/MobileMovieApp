package com.example.mymovieinfo.service

import android.content.ContentValues.TAG
import android.util.Log
import com.example.mymovieinfo.RetrofitClientInstance
import com.example.mymovieinfo.dao.ILocalMovieDAO
import com.example.mymovieinfo.dao.IMovieDAO
import com.example.mymovieinfo.dto.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

class MovieService {

    suspend fun fetchMovies() : List<Movie>? {
        return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(IMovieDAO::class.java)
            val movies = async {service?.getAllMovies()}
            var result = movies.await()?.awaitResponse()?.body()
            return@withContext result
        }
    }






} //End MovieService