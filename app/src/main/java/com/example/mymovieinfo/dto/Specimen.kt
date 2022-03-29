package com.example.mymovieinfo.dto

class Specimen(var MovieTitle: String = "", var MovieRank: Int = 0, var MovieCountry : String = "", var MovieBoxOfficeGross: String = "", var MovieOpeningWeekendGross : String = "", var MovieDistributor : String = "") {
    override fun toString(): String {
        return "$MovieTitle"
    }
}