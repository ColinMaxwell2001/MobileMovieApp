package com.example.mymovieinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
    var movieYear by remember { mutableStateOf("")}
    val context = LocalContext.value
    Column {
        OutlinedTextField(value = movieName,
            onValueChange = { movieName = it },
            label = { Text(context.getString(R.string.movieName)) }
        )
        OutlinedTextField(value = movieYear,
            onValueChange = { movieYear = it },
            label = { Text(context.getString(R.string.movieYear)) }
        )
        Button(
            onClick = {
                Toast.makeText(context, "$movieName $movieYear", Toast.LENGTH_LONG).show()
            }
        ){Text(text = "Find Movie")}
    }
}




