package com.example.mymovieinfo.dto

class Specimen(var movieTitle: String = "",
               var movieRank: Int = 0,
               var movieCountry : String = "",
               var movieBoxOfficeGross: String = "",
               var movieOpeningWeekendGross : String = "",
               var movieDistributor : String = "") {
    override fun toString(): String {
        return "$movieTitle"
    }
}