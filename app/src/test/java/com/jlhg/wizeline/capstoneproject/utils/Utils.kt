package com.jlhg.wizeline.capstoneproject.utils

import com.jlhg.wizeline.capstoneproject.domain.model.*
import com.jlhg.wizeline.local.db.entities.MovieDetailsEntity
import com.jlhg.wizeline.remote.Credentials
import com.jlhg.wizeline.remote.model.ListMoviesModel
import com.jlhg.wizeline.remote.model.MovieDetailsModel
import com.jlhg.wizeline.remote.model.ResultApi

object Utils {

    const val email = "qwerty@gmail.com"
    const val pass = "12345678"
    const val page = 1

    fun createMutableListMoviesModel(): ListMoviesModel {
        return ListMoviesModel(
            1,
            mutableListOf(
                ResultApi(1, "Pelicula 1", "Poster 1"),
                ResultApi(2, "Pelicula 2", "Poster 2"),
                ResultApi(3, "Pelicula 3", "Poster 3")
            ),
            1
        )
    }

    fun createMutableListMovieItem(): MutableList<MovieItem> {
        return mutableListOf(
            MovieItem(1, "Pelicula 1", "Poster 1"),
            MovieItem(2, "Pelicula 2", "Poster 2"),
            MovieItem(3, "Pelicula 3", "Poster 3")
        )
    }

    fun createMovieDetails(): MovieDetail {
        return MovieDetail(
            0,
            "path",
            listOf(Gender(1, "Genero 1"), Gender(2, "Genero 2")),
            "es",
            "Pelicula 1",
            "overview",
            "Poster 1",
            60,
            listOf(Language("Movie 1", "en", "English")),
            "status",
            10.0,
            1
        )
    }

    fun createMovieDetailsEntity(): MovieDetailsEntity {
        return MovieDetailsEntity(
            0,
            "path",
            listOf(com.jlhg.wizeline.local.db.entities.Gender(1, "Genero 1"), com.jlhg.wizeline.local.db.entities.Gender(2, "Genero 2")),
            "es",
            "Pelicula 1",
            "overview",
            "Poster 1",
            60,
            listOf(com.jlhg.wizeline.local.db.entities.Language("Movie 1", "en", "English")),
            "status",
            10.0,
            1
        )
    }

    fun createListGenders(): List<Gender>{
        return listOf(
            Gender(1, "Gender 1"),
            Gender(2, "Gender 2")
        )
    }

}