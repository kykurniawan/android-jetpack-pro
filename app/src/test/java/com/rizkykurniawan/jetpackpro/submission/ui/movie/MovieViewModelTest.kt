package com.rizkykurniawan.jetpackpro.submission.ui.movie

import com.rizkykurniawan.jetpackpro.submission.data.source.MovieRepository
import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity
import com.rizkykurniawan.jetpackpro.submission.utils.DummyData
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private val dummyMovie = DummyData.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId
    private val wrongMovieId = "wrongId"

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Before
    fun setUp() {
        viewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun testGetMovies() {
        `when`(movieRepository.getAllMovies()).thenReturn(DummyData.generateDummyMovies() as ArrayList<MovieEntity>)
        val movies = viewModel.getMovies()
        verify(movieRepository).getAllMovies()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun testGetDetailMovie() {
        `when`(movieRepository.getDetailMovie(movieId)).thenReturn(dummyMovie)
        val movie = viewModel.getDetailMovie(movieId)
        verify(movieRepository).getDetailMovie(movieId)
        assertNotNull(movie)
        assertEquals(dummyMovie, movie)
        assertEquals(dummyMovie.title, movie?.title)
        assertEquals(dummyMovie.score, movie?.score)
        assertEquals(dummyMovie.posterDrawable, movie?.posterDrawable)
        assertEquals(dummyMovie.releaseDate, movie?.releaseDate)
        assertEquals(dummyMovie.description, movie?.description)
    }

    @Test
    fun testGetDetailMovieWithWrongId() {
        `when`(movieRepository.getDetailMovie(wrongMovieId)).thenReturn(null)
        val movie = viewModel.getDetailMovie(wrongMovieId)
       assertNull(movie)
    }
}