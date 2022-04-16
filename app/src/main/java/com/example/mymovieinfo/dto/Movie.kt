package com.example.mymovieinfo.dto

import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("Rank") var Rank:String, @SerializedName("Title")var Title: String,
                 @SerializedName("Country_of_origin")var Country_of_origin:String, @SerializedName("Box_office_gross")var Box_office_gross:String,
                 @SerializedName("Opening_Weekend_Gross")var Opening_Weekend_Gross:String, @SerializedName("Distributor")var Distributor: String){

    override fun toString(): String {
        return Title
    }

} //End DataClass
