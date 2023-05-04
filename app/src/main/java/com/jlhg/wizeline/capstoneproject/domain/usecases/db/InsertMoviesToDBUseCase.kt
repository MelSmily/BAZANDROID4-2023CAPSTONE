package com.jlhg.wizeline.capstoneproject.domain.usecases.db

import com.jlhg.wizeline.capstoneproject.domain.model.*
import com.jlhg.wizeline.local.db.DatabaseRepository
import javax.inject.Inject

class InsertMoviesToDBUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository
) {
    suspend fun insertNowPlayingMovies(movies: MutableList<MovieItem>) {
        databaseRepository.insertNowPlayingMovies(
            movies.map {
                it.toNowPlayingMoviesEntity()
            }
        )
    }

    suspend fun insertTopRatedMovies(movies: MutableList<MovieItem>) {
        databaseRepository.insertTopRatedMovies(
            movies.map {
                it.toTopRatedMoviesEntity()
            }
        )
    }

    suspend fun insertLastestMovies(movies: MutableList<MovieItem>) {
        databaseRepository.insertLastestMovies(
            movies.map {
                it.toLastestMoviesEntity()
            }
        )
    }
}
