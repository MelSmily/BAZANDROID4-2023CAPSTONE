package com.jlhg.wizeline.capstoneproject.domain.model

import com.jlhg.wizeline.remote.Credentials
import com.jlhg.wizeline.local.db.entities.LastestMoviesEntity
import com.jlhg.wizeline.local.db.entities.NowPlayingMoviesEntity
import com.jlhg.wizeline.local.db.entities.TopRatedMoviesEntity
import com.jlhg.wizeline.remote.model.ResultApi

data class MovieItem(
    val id: Int,
    val title: String,
    val posterPath: String,
)

fun com.jlhg.wizeline.remote.model.ResultApi.toDomain(): MovieItem {
    val poster = "${com.jlhg.wizeline.remote.Credentials.PATH_IMG}${this.posterPath}"
    return MovieItem(id, title, poster)
}

fun com.jlhg.wizeline.local.db.entities.NowPlayingMoviesEntity.toDomain(): MovieItem{
    return MovieItem(id, title, posterPath)
}

fun com.jlhg.wizeline.local.db.entities.TopRatedMoviesEntity.toDomain(): MovieItem{
    return MovieItem(id, title, posterPath)
}

fun com.jlhg.wizeline.local.db.entities.LastestMoviesEntity.toDomain(): MovieItem{
    return MovieItem(id, title, posterPath)
}

fun MovieItem.toNowPlayingMoviesEntity(): com.jlhg.wizeline.local.db.entities.NowPlayingMoviesEntity {
    return com.jlhg.wizeline.local.db.entities.NowPlayingMoviesEntity(id, title, posterPath)
}

fun MovieItem.toTopRatedMoviesEntity(): com.jlhg.wizeline.local.db.entities.TopRatedMoviesEntity {
    return com.jlhg.wizeline.local.db.entities.TopRatedMoviesEntity(id, title, posterPath)
}

fun MovieItem.toLastestMoviesEntity(): com.jlhg.wizeline.local.db.entities.LastestMoviesEntity {
    return com.jlhg.wizeline.local.db.entities.LastestMoviesEntity(id, title, posterPath)
}