package com.example.mobilemovieapp.dto

data class Movie(var rank: Int, var name: String, var CoO: String, var BoG: Float, var OWG: Float, var distributor: String)
{
    override fun toString(): String {
        var result = name + " " + rank
        return result
    }
}
