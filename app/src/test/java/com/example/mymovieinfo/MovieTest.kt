package com.example.mymovieinfo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.mymovieinfo.dto.Movie
import com.example.mymovieinfo.service.MovieService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
//import junit.framework.Assert
import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.rules.TestRule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class MovieTests {


    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var movieService : MovieService
    var allMovies : List<Movie>? = ArrayList<Movie>()

    // MutableLiveData Test //
    lateinit var mvm: MainViewModel

    @MockK
    lateinit var mockMovieService : MovieService

    private val mainThreadSurrogate = newSingleThreadContext("Main Thread")

    @Before
    fun initMocksAndMainThread() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }


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

    @Test
    fun `Given a view model with live data when populated with movies then results show Joker`() = runTest {
        givenViewModelIsInitializedWithMockData()
        whenMovieServiceFetchMoviesInvoked()
        thenResultsShouldContainRank4andWarnerBros()
    }

    private fun givenViewModelIsInitializedWithMockData() {
        val movies = ArrayList<Movie>()
        movies.add(Movie("4", "Joker", "USA/Can",
            "58.1","12.6", "Warner Bros"))

        coEvery { mockMovieService.fetchMovies() } returns movies

        mvm = MainViewModel(movieService = mockMovieService)
        // mvm.movieService = mockMovieService

    }

    private fun whenMovieServiceFetchMoviesInvoked() {
        mvm.fetchMovies()

    }

    private fun thenResultsShouldContainRank4andWarnerBros() {
        var allMovies : List<Movie>? = ArrayList<Movie>()
        val latch = CountDownLatch(1)
        val observer = object : Observer<List<Movie>> {
            override fun onChanged(t: List<Movie>?) {
                allMovies = t
                latch.countDown()
                mvm.movies.removeObserver(this)
            }
        }
        mvm.movies.observeForever(observer)
        latch.await(10, TimeUnit.SECONDS)
        assertNotNull(allMovies)
        assertTrue(allMovies!!.isNotEmpty())
        var containsJoker = false
        allMovies!!.forEach {
            if(it.Title.equals(("Joker")) && it.Rank.equals(("4")) && it.Distributor.equals(("Warner Bros"))){
                containsJoker = true
            }
        }
        assertTrue(containsJoker)
    }


} //End Class