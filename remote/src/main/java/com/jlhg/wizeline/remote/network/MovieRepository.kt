package com.jlhg.wizeline.remote.network

import com.jlhg.wizeline.remote.model.ListMoviesModel
import com.jlhg.wizeline.remote.model.MovieDetailsModel
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getTopRatedMovies(page: Int): ListMoviesModel? {
        return apiService.getTopRatedMovies(page)
    }

    suspend fun getNowPlayingMovies(page: Int): ListMoviesModel? {
        return apiService.getNowPlayingMovies(page)
    }

    suspend fun getLastestMovies(page: Int): ListMoviesModel? {
        return apiService.getLastestMovies(page)
    }

    suspend fun getDetailsMovie(id: Int): MovieDetailsModel? {
        return apiService.getMovieId(id)
    }
}
