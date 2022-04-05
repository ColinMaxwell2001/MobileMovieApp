package com.example.mymovieinfo
import android.annotation.SuppressLint
import android.app.SearchManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
import java.io.InputStream
import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val year = findViewById<TextView>(R.id.txtYear)
        val name = findViewById<TextView>(R.id.txtMovieName)
        val result = findViewById<TextView>(R.id.txtResults)


        val btnFindMyMovie = findViewById<Button>(R.id.btnFindMyMovie)
        btnFindMyMovie.setOnClickListener {
            // your code to perform when the user clicks on the button

            result.text = "the $name was released in $year"
        }
    }





}