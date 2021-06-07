package com.rizkykurniawan.jetpackpro.submission.data.source

import com.rizkykurniawan.jetpackpro.submission.data.source.remote.RemoteDataSource
import com.rizkykurniawan.jetpackpro.submission.utils.DummyData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class MovieRepositoryTest {

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val moviesResponse = DummyData.generateRemoteDummyMovies()
    private val dummyMovie = moviesResponse[0]
    private val movieId = dummyMovie.movieId

//    @Test
//    fun getAllMovies() {
//        `when`(remote.getAllMovies()).thenReturn(moviesResponse)
//        val movieEntities = movieRepository.getAllMovies()
//        verify(remote).getAllMovies()
//        assertNotNull(movieEntities)
//        assertEquals(moviesResponse.size.toLong(), movieEntities.size.toLong())
//    }
//
//    @Test
//    fun getDetailMovie() {
//        `when`(remote.getDetailMovie(movieId)).thenReturn(dummyMovie)
//        val movie = movieRepository.getDetailMovie(movieId)
//        verify(remote).getDetailMovie(movieId)
//        assertNotNull(movie)
//        assertEquals(movie?.title, dummyMovie.title)
//    }
}