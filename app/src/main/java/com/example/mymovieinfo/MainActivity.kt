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
import com.example.mymovieinfo.dto.Movie

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var year = findViewById<TextView>(R.id.txt_Year)
        var name = findViewById<TextView>(R.id.txt_MovieName)
        var result = findViewById<TextView>(R.id.txt_Results)


        val btnFindMyMovie = findViewById<Button>(R.id.btn_FindMyMovie)
        btnFindMyMovie.setOnClickListener {
                // your code to perform when the user clicks on the button

            result.text = "the $name was released in $year"

                //Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
        }
        }
    }