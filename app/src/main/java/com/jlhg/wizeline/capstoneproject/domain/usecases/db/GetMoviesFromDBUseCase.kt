package com.jlhg.wizeline.capstoneproject.domain.usecases.db

import com.jlhg.wizeline.capstoneproject.domain.model.MovieItem
import com.jlhg.wizeline.capstoneproject.domain.model.toDomain
import com.jlhg.wizeline.local.db.DatabaseRepository
import javax.inject.Inject

class GetMoviesFromDBUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository,
) {
    suspend fun getNowPlayingMovies(): MutableList<MovieItem> {
        return databaseRepository.getNowPlayingMovies()
            .map { it.toDomain() } as MutableList<MovieItem>
    }

    suspend fun getTopRatedMovies(): MutableList<MovieItem> {
        return databaseRepository.getTopRatedMovies()
            .map { it.toDomain() } as MutableList<MovieItem>
    }

    suspend fun getLastestMovies(): MutableList<MovieItem> {
        return databaseRepository.getLastestMovies()
            .map { it.toDomain() } as MutableList<MovieItem>
    }
}
