package com.jlhg.wizeline.capstoneproject.domain.model

import com.jlhg.wizeline.remote.Credentials
import com.jlhg.wizeline.remote.model.MovieDetailsModel
import com.jlhg.wizeline.local.db.entities.MovieDetailsEntity

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

data class Gender(
    val id: Int,
    val name: String
)

data class Language(
    val englishName: String,
    val iso: String,
    val name: String,
)

fun com.jlhg.wizeline.remote.model.MovieDetailsModel.toDomain(): MovieDetail {
    return MovieDetail(
        id = id ?: 0,
        backdropPath = if (backdropPath.isNullOrEmpty()) "" else "${com.jlhg.wizeline.remote.Credentials.PATH_IMG}${this.backdropPath}",
        genres = genres!!.map { it.toDomain() },
        originalLanguage = originalLanguage ?: "",
        originalTitle = originalTitle ?: "",
        overview = overview ?: "",
        posterPath = "${com.jlhg.wizeline.remote.Credentials.PATH_IMG}${this.posterPath}",
        runtime = runtime ?: 0,
        spokenLanguages = spokenLanguages.map { it.toDomain() },
        status = status,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}

private fun com.jlhg.wizeline.remote.model.Gender.toDomain(): Gender{
    return Gender(id, name)
}

private fun com.jlhg.wizeline.remote.model.Language.toDomain(): Language{
    return Language(englishName, iso, name)
}

fun com.jlhg.wizeline.local.db.entities.MovieDetailsEntity.toDomain(): MovieDetail {
    return MovieDetail(
        id = id,
        backdropPath = backdropPath,
        genres = genres.map { it.toDomain() },
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath,
        runtime = runtime,
        spokenLanguages = spokenLanguages.map { it.toDomain() },
        status = status,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}

private fun com.jlhg.wizeline.local.db.entities.Gender.toDomain(): Gender{
    return Gender(id, name)
}

private fun com.jlhg.wizeline.local.db.entities.Language.toDomain(): Language{
    return Language(englishName, iso, name)
}

fun MovieDetail.toMovieDetailsEntity(): com.jlhg.wizeline.local.db.entities.MovieDetailsEntity {
    return com.jlhg.wizeline.local.db.entities.MovieDetailsEntity(
        id = id,
        backdropPath = backdropPath,
        genres = genres.map { it.toEntity() },
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        overview = overview,
        posterPath = posterPath,
        runtime = runtime,
        spokenLanguages = spokenLanguages.map { it.toEntity() },
        status = status,
        voteAverage = voteAverage,
        voteCount = voteCount
    )
}

private fun Gender.toEntity(): com.jlhg.wizeline.local.db.entities.Gender {
    return com.jlhg.wizeline.local.db.entities.Gender(id, name)
}

private fun Language.toEntity(): com.jlhg.wizeline.local.db.entities.Language {
    return com.jlhg.wizeline.local.db.entities.Language(englishName, iso, name)
}