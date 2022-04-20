package com.example.mymovieinfo.dto

data class Specimen(var MovieTitle: String = "", var Movierank: Int = 0, var MovieCountry : String = "", var MovieBoxOfficeGross: Double, var MovieOpeningWeekendGross : Double, var movieDistributor : String = "") {
    override fun toString(): String {
        return "$MovieTitle $MovieCountry"
    }
}