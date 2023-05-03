package com.jlhg.wizeline.capstoneproject.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jlhg.wizeline.capstoneproject.remote.model.Gender
import com.jlhg.wizeline.capstoneproject.remote.model.Language

@Entity(tableName = "movie_details")
data class MovieDetailsEntity(
    @PrimaryKey
    val id: Int,
    val backdropPath: String,
    val genres: List<Gender>,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val posterPath: String,
    val runtime: Int,
    val spokenLanguages: List<Language>,
    val status: String,
    val voteAverage: Double,
    val voteCount: Int
)