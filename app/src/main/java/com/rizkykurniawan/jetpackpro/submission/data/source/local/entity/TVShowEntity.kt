package com.rizkykurniawan.jetpackpro.submission.data.source.local.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TVShowEntity(
        var tvShowId: String,
        var title: String,
        var description: String,
        var score: String,
        var season: Int,
        var posterDrawable: String,
): Parcelable
