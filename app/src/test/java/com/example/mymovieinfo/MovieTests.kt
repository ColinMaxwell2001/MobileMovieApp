package com.example.mymovieinfo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mymovieinfo.dto.Movie
import com.example.mymovieinfo.service.MovieService
//import junit.framework.Assert
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MovieTests {


    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var movieService : MovieService
    var allMovies : List<Movie>? = ArrayList<Movie>()

    @Test
    fun `Given movie data are available when I search for Joker then I should receive Joker movie data`() = runTest {
        givenMovieServiceIsInitialized()
        whenMovieDataAreReadAndParsed()
        thenTheMovieCollectionShouldContainJokerData()
    }

    private fun givenMovieServiceIsInitialized() {
        movieService = MovieService()
    }
    private suspend fun whenMovieDataAreReadAndParsed() {
        allMovies = movieService.fetchMovies()

    }

    private fun thenTheMovieCollectionShouldContainJokerData() {
        assertNotNull(allMovies)
        assertTrue(allMovies!!.isNotEmpty())
        var containsJoker = false
        allMovies!!.forEach {
            if(it.Title.equals("Joker")) {
                containsJoker = true
            }
        }
        assertTrue(containsJoker)
    }


}