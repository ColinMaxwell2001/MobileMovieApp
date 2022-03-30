package com.example.mymovieinfo.dto

import androidx.lifecycle.Transformations.map
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

public data class Movie(@SerializedName("rank")var rank: Int, @SerializedName("title")var title: String,
                 @SerializedName("country") var country: String, @SerializedName("boxOfficeGross")var boxOfficeGross: Double,
                 @SerializedName("openingWeekendGross")var openingWeekendGross: Double, @SerializedName("distributor")var distributor: String){

    override fun toString(): String {
        return title
    }
    val map: MutableMap<String, String> = HashMap()
    //for (movie in Movie) {
    //    map[movie.title] = movie.country
    //}

} //End DataClass
