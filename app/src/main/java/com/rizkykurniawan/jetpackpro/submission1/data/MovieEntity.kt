package com.rizkykurniawan.jetpackpro.submission1.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
        var movieId: Int,
        var title: String,
        var description: String,
        var score: String,
        var releaseDate: String,
        var posterDrawable: Int,
): Parcelable
