package com.jlhg.wizeline.capstoneproject.domain.model

import com.jlhg.wizeline.capstoneproject.core.Credentials
import com.jlhg.wizeline.capstoneproject.data.model.ResultApi

data class MovieItem(
    val id: Int,
    val title: String,
    val posterPath: String,
)

fun ResultApi.toDomain(): MovieItem {
    val poster = "${Credentials.PATH_IMG}${this.posterPath}"
    return MovieItem(id, title, poster)
}