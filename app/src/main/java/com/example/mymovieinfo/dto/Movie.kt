package com.example.mymovieinfo.dto

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class Movie(@SerializedName("rank")var rank: Int, @SerializedName("title")var title: String,
                 @SerializedName("country") var country: String, @SerializedName("boxOfficeGross")var boxOfficeGross: Double,
                 @SerializedName("openingWeekendGross")var openingWeekendGross: Double, @SerializedName("distributor")var distributor: String){

    override fun toString(): String {
        return title
    }

    val gson = Gson()

    //convert a data class to a map
    fun <T> T.serializeToMap(): Map<String, Any> {
        return convert()
    }

    //convert a map to a data class
    inline fun <reified T> Map<String, Any>.toDataClass(): T {
        return convert()
    }

    //convert an object of type I to type O
    inline fun <I, reified O> I.convert(): O {
        val json = gson.toJson(this)
        return gson.fromJson(json, object : TypeToken<O>() {}.type)
    }


} //End DataClass
