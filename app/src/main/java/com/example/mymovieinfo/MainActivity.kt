package com.example.mymovieinfo
import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
import java.io.InputStream
import android.content.Context;
import android.content.Intent
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

class MainActivity : AppCompatActivity() {

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

            result.text = "the $name was released in $year"


            //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
        setContent {
            viewModel.fetchCountries()
            val movies by viewModel.movies.observeAsState(initial = emptyList())
        }
    }

    @Composable
    annotation class Composable

}
