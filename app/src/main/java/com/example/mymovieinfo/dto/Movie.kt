package com.example.mymovieinfo.dto

data class Movie(var rank: Int, var title: String,
                 var country: String,var boxOfficeGross: Double,
                 var openingWeekendGross: Double, var distributor: String){

    override fun toString(): String {
        return title
        //Test Push
    }

} //End DataClass
