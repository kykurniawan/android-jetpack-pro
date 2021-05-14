package com.rizkykurniawan.jetpackpro.submission1.ui.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rizkykurniawan.jetpackpro.submission1.R
import com.rizkykurniawan.jetpackpro.submission1.data.MovieEntity
import com.rizkykurniawan.jetpackpro.submission1.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var movieDetailBinding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        movieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(movieDetailBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getParcelableExtra<MovieEntity>(EXTRA_MOVIE)
        Glide.with(this).load(movie?.posterDrawable).into(movieDetailBinding.imgPoster)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}