package com.example.mymovieinfo
import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
import java.io.InputStream
import android.content.Context;
import android.content.Intent
import android.util.Log
import android.view.View;
import android.widget.Button;
import android.widget.TextView
import android.widget.Toast;
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import com.example.mymovieinfo.dto.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.runtime.livedata.observeAsState

import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    val url = "https://api.jsonbin.io/b/6227c3b9a703bb674925773a"


    private val viewModel: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var year = findViewById(R.id.txt_Year) as TextView
        var name = findViewById(R.id.txt_MovieName) as TextView
        var result = findViewById(R.id.txt_Results) as TextView


        val btn_FindMyMovie = findViewById(R.id.btn_FindMyMovie) as Button
        btn_FindMyMovie.setOnClickListener {
            // your code to perform when the user clicks on the button
            downloadTask()
            result.text = "the $name was released in $year"


            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
        setContent {
            viewModel.fetchCountries()
            val movies by viewModel.movies.observeAsState(initial = emptyList())
        }
    }

    fun downloadTask() {

        val queue = Volley.newRequestQueue(this)
        val request = StringRequest(Request.Method.GET, url,
            Response.Listener { response ->
                val data = response.toString()
                var jArray = JSONArray(data)
                for (i in 0..jArray.length() - 1) {
                    var jobject = jArray.getJSONObject(i)
                    var rankId = jobject.getInt("Rank")
                    var titleId = jobject.getString("Title")
                    var countryOfOriginId = jobject.getString("Country_of_origin")

                    var boxOfficeGrossId = jobject.getDouble("Box_office_gross")
                    var openingWeekendGrossId = jobject.getString("Opening_Weekend_Gross")
                    var distributorId = jobject.getString("Distributor")
                    Log.e("Rank", rankId.toString())
                    Log.e("Title", titleId.toString())
                    Log.e("Country_of_origin", countryOfOriginId.toString())
                    Log.e("Box_office_gross", boxOfficeGrossId.toString())
                    Log.e("Opening_Weekend_Gross", openingWeekendGrossId.toString())
                    Log.e("Distributor", distributorId.toString())


                }
            }, Response.ErrorListener { })
        queue.add(request)
    }

}