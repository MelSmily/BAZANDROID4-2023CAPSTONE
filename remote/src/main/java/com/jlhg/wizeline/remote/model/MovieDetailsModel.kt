package com.jlhg.wizeline.remote.model

import com.google.gson.annotations.SerializedName

data class MovieDetailsModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    @SerializedName("genres")
    val genres: List<Gender>?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("runtime")
    val runtime: Int?,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<Language>,
    @SerializedName("status")
    val status: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
)

data class Gender(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
)

data class Language(
    @SerializedName("english_name")
    val englishName: String,
    @SerializedName("iso_639_1")
    val iso: String,
    @SerializedName("name")
    val name: String,
)
