package com.rizkykurniawan.jetpackpro.submission1.ui.movie

import androidx.lifecycle.ViewModel
import com.rizkykurniawan.jetpackpro.submission1.data.MovieEntity
import com.rizkykurniawan.jetpackpro.submission1.utils.DummyData

class MovieViewModel: ViewModel() {
    fun getMovies(): List<MovieEntity> = DummyData.generateDummyMovies()
}