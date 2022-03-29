package com.example.mymovieinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
import java.io.InputStream
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_FindMyMovie = findViewById(R.id.btn_FindMyMovie) as Button
         btn_FindMyMovie.setOnClickListener {
             // your code to perform when the user clicks on the button
             Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()
         }
    }




}