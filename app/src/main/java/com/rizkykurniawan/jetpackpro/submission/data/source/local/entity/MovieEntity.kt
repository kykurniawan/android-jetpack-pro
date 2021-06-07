package com.rizkykurniawan.jetpackpro.submission.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
        var movieId: String,
        var title: String,
        var description: String,
        var score: String,
        var releaseDate: String,
        var posterDrawable: String,
): Parcelable
