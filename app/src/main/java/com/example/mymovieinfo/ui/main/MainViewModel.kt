package com.example.mymovieinfo.ui.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieinfo.dto.Movie
import com.example.mymovieinfo.dto.Specimen
import com.example.mymovieinfo.service.MovieService
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // Implements the movie service fetch movies list to create a live data list of the movies
    var movies : MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    private var movieService : MovieService = MovieService()
    private var _specimens: MutableLiveData<ArrayList<Specimen>> = MutableLiveData<ArrayList<Specimen>>()

    private lateinit var firestore: FirebaseFirestore

    init{
        listenToSpecimens()
    }

    /*
    This will hear any from firestore
     */
    private fun listenToSpecimens() {
        firestore.collection("specimens").addSnapshotListener{
            snapshot, e ->
        if (e != null){
            Log.w(TAG,"Listen Failed", e)
            return@addSnapshotListener
        }
            if(snapshot != null){
                val allSpecimens = ArrayList<Specimen>()
                val documents = snapshot.documents
                documents.forEach{
                    val specimen = it.toObject(Specimen::class.java)
                    if (specimen != null){
                        allSpecimens.add(specimen!!)
                    }
                }
                _specimens.value = allSpecimens
            }
        }
    }

    fun fetchCountries() {
        viewModelScope.launch{
            var innerMovies = movieService.fetchMovies()
            movies.postValue(innerMovies!!)
        }
    }

    internal var specimens: MutableLiveData<ArrayList<Specimen>>
    get(){return _specimens}
    set(value) {_specimens = value}

}