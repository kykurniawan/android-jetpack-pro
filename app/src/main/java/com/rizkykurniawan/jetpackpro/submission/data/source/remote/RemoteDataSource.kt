package com.rizkykurniawan.jetpackpro.submission.data.source.remote

import android.os.Handler
import android.os.Looper
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.response.MovieResponse
import com.rizkykurniawan.jetpackpro.submission.data.source.remote.response.TVShowResponse
import com.rizkykurniawan.jetpackpro.submission.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(helper).apply { instance = this }
            }
    }

    fun getAllMovies(callBack: LoadMoviesCallBack) {
        handler.postDelayed(
            { callBack.onAllMoviesReceived(jsonHelper.loadMovies()) },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getDetailMovie(movieId: String?, callBack: LoadMovieCallBack) {
        handler.postDelayed(
            { callBack.onMovieReceived(jsonHelper.loadDetailMovie(movieId)) },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getAllTVShows(callBack: LoadTVShowsCallBack) {
        handler.postDelayed(
            { callBack.onAllTVShowsReceived(jsonHelper.loadTVShows()) },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getDetailTVShow(tvShowId: String?, callBack: LoadTVShowCallBack) {
        handler.postDelayed(
            { callBack.onTVShowReceived(jsonHelper.loadDetailTVShow(tvShowId)) },
            SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface LoadMoviesCallBack {
        fun onAllMoviesReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadTVShowsCallBack {
        fun onAllTVShowsReceived(tvShowResponses: List<TVShowResponse>)
    }

    interface LoadMovieCallBack {
        fun onMovieReceived(movieResponse: MovieResponse?)
    }

    interface LoadTVShowCallBack {
        fun onTVShowReceived(tvShowResponse: TVShowResponse?)
    }

}