package com.example.mymovieinfo.dao

import androidx.room.Database
import androidx.room.RoomDatabase

abstract class MovieDatabase : RoomDatabase(){
    abstract fun localMovieDAO() : ILocalMovieDAO

}