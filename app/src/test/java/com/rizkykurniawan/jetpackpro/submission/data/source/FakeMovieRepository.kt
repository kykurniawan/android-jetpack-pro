package com.rizkykurniawan.jetpackpro.submission.data.source

import com.rizkykurniawan.jetpackpro.submission.data.source.local.entity.MovieEntity
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.RemoteDataSource

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource): MovieDataSource {

    override fun getAllMovies(): List<MovieEntity> {
        val movieResponses = remoteDataSource.getAllMovies()
        val movieList = ArrayList<MovieEntity>()
        for (response in movieResponses) {
            val movie = MovieEntity(
                response.movieId,
                response.title,
                response.description,
                response.score,
                response.releaseDate,
                response.posterDrawable
            )
            movieList.add(movie)
        }
        return movieList
    }

    override fun getDetailMovie(movieId: String?): MovieEntity? {
        val movieResponse = remoteDataSource.getDetailMovie(movieId)
        if(movieResponse != null) {
            return MovieEntity(
                movieResponse.movieId,
                movieResponse.title,
                movieResponse.description,
                movieResponse.score,
                movieResponse.releaseDate,
                movieResponse.posterDrawable
            )
        }
        return null
    }
}