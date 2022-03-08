package com.example.mymovieinfo.dto

import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("rank")var rank: Int, @SerializedName("title")var title: String,
                 @SerializedName("country") var country: String, @SerializedName("boxOfficeGross")var boxOfficeGross: Double,
                 @SerializedName("openingWeekendGross")var openingWeekendGross: Double, @SerializedName("distributor")var distributor: String){

    override fun toString(): String {
        return title
    }

} //End DataClass
