package com.jlhg.wizeline.capstoneproject.domain.model

import com.jlhg.wizeline.local.db.entities.LastestMoviesEntity
import com.jlhg.wizeline.local.db.entities.NowPlayingMoviesEntity
import com.jlhg.wizeline.local.db.entities.TopRatedMoviesEntity
import com.jlhg.wizeline.remote.Credentials
import com.jlhg.wizeline.remote.model.ResultApi

data class MovieItem(
    val id: Int,
    val title: String,
    val posterPath: String,
)

fun ResultApi.toDomain(): MovieItem {
    val poster = "${Credentials.PATH_IMG}${this.posterPath}"
    return MovieItem(id, title, poster)
}

fun NowPlayingMoviesEntity.toDomain(): MovieItem {
    return MovieItem(id, title, posterPath)
}

fun TopRatedMoviesEntity.toDomain(): MovieItem {
    return MovieItem(id, title, posterPath)
}

fun LastestMoviesEntity.toDomain(): MovieItem {
    return MovieItem(id, title, posterPath)
}

fun MovieItem.toNowPlayingMoviesEntity(): NowPlayingMoviesEntity {
    return NowPlayingMoviesEntity(id, title, posterPath)
}

fun MovieItem.toTopRatedMoviesEntity(): TopRatedMoviesEntity {
    return TopRatedMoviesEntity(id, title, posterPath)
}

fun MovieItem.toLastestMoviesEntity(): LastestMoviesEntity {
    return LastestMoviesEntity(id, title, posterPath)
}
