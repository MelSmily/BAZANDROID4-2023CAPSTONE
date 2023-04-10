package com.jlhg.wizeline.capstoneproject.domain.usecases

import com.jlhg.wizeline.capstoneproject.data.network.MovieRepository
import com.jlhg.wizeline.capstoneproject.domain.model.MovieItem
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend fun getTopRatedMovies(page: Int): MutableList<MovieItem> {
        return movieRepository.getTopRatedMovies(page)
    }

    suspend fun getNowPlayingMovies(page: Int): MutableList<MovieItem> {
        return movieRepository.getNowPlayingMovies(page)
    }

    suspend fun getLastestMovies(page: Int): MutableList<MovieItem> {
        return movieRepository.getLastestMovies(page)
    }
}