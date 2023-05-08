package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.capstoneproject.domain.model.MovieItem
import com.jlhg.wizeline.capstoneproject.domain.model.toDomain
import com.jlhg.wizeline.remote.network.MovieRepository
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
) {

    suspend fun getTopRatedMovies(page: Int): MutableList<MovieItem> {
        val response = movieRepository.getTopRatedMovies(page)
        return response?.results?.map { it.toDomain() } as MutableList<MovieItem>
    }

    suspend fun getNowPlayingMovies(page: Int): MutableList<MovieItem> {
        val response = movieRepository.getNowPlayingMovies(page)
        return response?.results?.map { it.toDomain() } as MutableList<MovieItem>
    }

    suspend fun getLastestMovies(page: Int): MutableList<MovieItem> {
        val response = movieRepository.getLastestMovies(page)
        return response?.results?.map { it.toDomain() } as MutableList<MovieItem>
    }
}
