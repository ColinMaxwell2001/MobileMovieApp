package com.example.mymovieinfo.service

import android.content.ContentValues.TAG
import android.util.Log
import androidx.room.Room
import com.example.mymovieinfo.RetrofitClientInstance
import com.example.mymovieinfo.dao.ILocalMovieDAO
import com.example.mymovieinfo.dao.IMovieDAO
import com.example.mymovieinfo.dao.MovieDatabase
import com.example.mymovieinfo.dto.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import retrofit2.awaitResponse

import android.app.Application

class MovieService(application: Application) {
    private val application = application

    suspend fun fetchMovies() : List<Movie>? {
        return withContext(Dispatchers.IO) {
            val service = RetrofitClientInstance.retrofitInstance?.create(IMovieDAO::class.java)
            val movies = async {service?.getAllMovies()}
            var result = movies.await()?.awaitResponse()?.body()
            return@withContext result
        }
    }


    internal fun save(movie:Movie) {
        getLocalMovieDAO().save(movie)
    }

    


    //GetLocalPlantDAO Method
    internal fun getLocalMovieDAO() : ILocalMovieDAO {
        val db = Room.databaseBuilder(application, MovieDatabase::class.java, "mymovies").build()
        val localMovieDAO = db.localMovieDAO()
        return localMovieDAO
    }


} //End MovieService