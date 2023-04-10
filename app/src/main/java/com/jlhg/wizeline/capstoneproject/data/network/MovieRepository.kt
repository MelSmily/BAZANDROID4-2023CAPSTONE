package com.jlhg.wizeline.capstoneproject.data.network

import com.jlhg.wizeline.capstoneproject.core.Credentials
import com.jlhg.wizeline.capstoneproject.data.model.ListMoviesModel
import com.jlhg.wizeline.capstoneproject.domain.model.MovieDetailsItem
import com.jlhg.wizeline.capstoneproject.domain.model.MovieItem
import com.jlhg.wizeline.capstoneproject.domain.model.toDomain
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getTopRatedMovies(page: Int): MutableList<MovieItem> {
        val response = apiService.getTopRatedMovies(page)
        Credentials.pagesTotal = response?.pTotal() ?: 1
        return response?.results?.map { it.toDomain() } as MutableList<MovieItem>
    }

    suspend fun getNowPlayingMovies(page: Int): MutableList<MovieItem> {
        val response = apiService.getNowPlayingMovies(page)
        Credentials.pagesTotal = response?.pTotal() ?: 1
        return response?.results?.map { it.toDomain() } as MutableList<MovieItem>
    }

    suspend fun getLastestMovies(page: Int): MutableList<MovieItem> {
        val response = apiService.getLastestMovies(page)
        Credentials.pagesTotal = response?.pTotal() ?: 1
        return response?.results?.map { it.toDomain() } as MutableList<MovieItem>
    }

    private fun ListMoviesModel.pTotal() = totalPages

    suspend fun getDetailsMovie(id: Int): MovieDetailsItem? {
        val response = apiService.getMovieId(id)
        return response?.toDomain()
    }
}