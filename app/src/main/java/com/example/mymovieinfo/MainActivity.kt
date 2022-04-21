package com.example.mymovieinfo
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.mymovieinfo.dto.Movie
import com.example.mymovieinfo.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private var selectedMovie : Movie? = null
    private var inMovieName: String = ""
    var movieName = (findViewById<View>(R.id.MovieName) as EditText)

    var movieCountry = (findViewById<View>(R.id.MovieCountry) as EditText)

    private val applicationViewModel : ApplicationViewModel by viewModel<ApplicationViewModel>()


    private val viewModel: MainViewModel by viewModel<MainViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val btn_FindMyMovie = findViewById<Button>(R.id.btn_FindMyMovie)
        btn_FindMyMovie.setOnClickListener {
            val movieString = movieName.text.toString()
        //viewModel.getMovie("")
            val movieCountryString=movieCountry.text.toString()
            viewModel.findMyMovie(movieString,movieCountryString)

        }

        setContent {
            viewModel.fetchCountries()
            val movies by viewModel.movies.observeAsState(initial = emptyList())
        }
        val textView = findViewById<EditText>(R.id.txt_Results)
        val movieFoundObserver = Observer<List <Movie>> {
            movies -> textView.setText(getMovieString(movies))
        }
        viewModel.movieFound.observe(this, movieFoundObserver)
        //val location by applicationViewModel.getLocationLiveData().observeAsState()

    }
    fun getMovieString (movie: List<Movie> ) :String {
        val builder = StringBuilder ()
        for(m in movie ) {
            builder.apply{

                append ("Title "+m.title+"\n")
                append ("Country of Origin "+m.country+"\n")
                append ("Box Office Gross "+m.boxOfficeGross+"\n")
                append ("Opening Weekend Gross "+m.openingWeekendGross+"\n")
                append ("Distributor "+m.distributor+"\n")
            }
        }
        return builder.toString()
    }
    //auto complete function
    @Composable
    fun TextFieldWithDropdownUsage(dataIn: List<Movie>, label: String = "", take: Int = 3) {
        val dropDownOptions = remember { mutableStateOf(listOf<Movie>()) }
        val textFieldValue = remember { mutableStateOf(TextFieldValue()) }
        val dropDownExpanded = remember { mutableStateOf(false) }
        fun onDropdownDismissRequest() {
            dropDownExpanded.value = false
        }
        fun onValueChanged(value: TextFieldValue) {
            inMovieName = value.text
            dropDownExpanded.value = true
            textFieldValue.value = value
            dropDownOptions.value = dataIn.filter {
                it.toString().startsWith(value.text) && it.toString() != value.text
            }.take(take)
        }
        TextFieldWithDropdown(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            value = textFieldValue.value,
            setValue = ::onValueChanged,
            onDismissRequest = ::onDropdownDismissRequest,
            dropDownExpanded = dropDownExpanded.value,
            list = dropDownOptions.value,
            label = label
        )
    }

    @Composable
    fun TextFieldWithDropdown(
        modifier: Modifier = Modifier,
        value: TextFieldValue,
        setValue: (TextFieldValue) -> Unit,
        onDismissRequest: () -> Unit,
        dropDownExpanded: Boolean,
        list: List<Movie>,
        label: String = ""
    ) {
        Box(modifier) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        if (!focusState.isFocused)
                            onDismissRequest()
                    },
                value = value,
                onValueChange = setValue,
                label = { Text(label) },
                colors = TextFieldDefaults.outlinedTextFieldColors()
            )
            DropdownMenu(
                expanded = dropDownExpanded,
                properties = PopupProperties(
                    focusable = false,
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true
                ),
                onDismissRequest = onDismissRequest
            ) {
                list.forEach { text ->
                    DropdownMenuItem(onClick = {
                        setValue(
                            TextFieldValue(
                                text.toString(),
                                TextRange(text.toString().length)
                            )
                        )
                        selectedMovie = text
                    }) {
                        Text(text = text.toString())
                    }
                }
            }
        }
    }


}
