package com.jlhg.wizeline.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

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

data class Gender(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)

data class Language(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("iso_639_1")
    val iso: String,
    @SerializedName("name")
    val name: String,
)