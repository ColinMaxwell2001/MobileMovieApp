package com.example.mymovieinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContent{
            FindMovie()
        }
    }
}

@Composable
fun FindMovie(){
    var movieName by remember { mutableStateOf("")}
    OutlinedTextField(value = movieName,
    onValueChange = {movieName = it},
    label = {Text(context.getString(R.string.movieName))}
    )
    var movieYear by remember { mutableStateOf("")}
    OutlinedTextField(value = movieYear,
        onValueChange = {movieYear = it},
        label = {Text(context.getString(R.string.movieYear))}
    )

}




