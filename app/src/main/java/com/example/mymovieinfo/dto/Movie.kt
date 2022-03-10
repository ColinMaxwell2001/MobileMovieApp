package com.example.mymovieinfo.dto

import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("Rank")var rank: Int, @SerializedName("Title")var title: String,
                 @SerializedName("Country_of_origin") var country: String, @SerializedName("Box_office_gross")var boxOfficeGross: Double,
                 @SerializedName("Opening_Weekend_Gross")var openingWeekendGross: Double, @SerializedName("Distributor")var distributor: String){

    override fun toString(): String {
        return "$title"
    }

} //End DataClass
