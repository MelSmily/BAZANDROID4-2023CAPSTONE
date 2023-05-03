package com.jlhg.wizeline.capstoneproject.domain.model

import com.jlhg.wizeline.capstoneproject.remote.Credentials
import com.jlhg.wizeline.capstoneproject.local.db.entities.MovieDetailsEntity
import com.jlhg.wizeline.capstoneproject.remote.model.Gender
import com.jlhg.wizeline.capstoneproject.remote.model.Language
import com.jlhg.wizeline.capstoneproject.remote.model.MovieDetailsModel

data class MovieDetail(
    val id: Int = 0,
    val backdropPath: String = "",
    val genres: List<Gender> = listOf(),
    val originalLanguage: String = "",
    val originalTitle: String = "",
    val overview: String = "",
    val posterPath: String = "",
    val runtime: Int = 0,
    val spokenLanguages: List<Language> = listOf(),
    val status: String = "",
    val voteAverage: Double = 0.0,
    val voteCount: Int = 0
)

fun MovieDetailsModel.toDomain(): MovieDetail {
    return MovieDetail(
        id = id ?: 0,
        backdropPath = if (backdropPath.isNullOrEmpty()) "" else "${Credentials.PATH_IMG}${this.backdropPath}",
        genres = genres ?: listOf(),
        originalLanguage = originalLanguage ?: "",
        originalTitle = originalTitle ?: "",
        overview = overview ?: "",
        posterPath = "${Credentials.PATH_IMG}${this.posterPath}",
        runtime = runtime ?: 0,
        spokenLanguages = spokenLanguages,
        status = status,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}

fun MovieDetailsEntity.toDomain(): MovieDetail? {
    return MovieDetail(
        id = id,
        backdropPath = backdropPath,
        genres = genres,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath,
        runtime = runtime,
        spokenLanguages = spokenLanguages,
        status = status,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}

fun MovieDetail.toMovieDetailsEntity(): MovieDetailsEntity {
    return MovieDetailsEntity(
        id = id,
        backdropPath = backdropPath,
        genres = genres,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath,
        runtime = runtime,
        spokenLanguages = spokenLanguages,
        status = status,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}