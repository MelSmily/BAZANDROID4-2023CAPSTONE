package com.jlhg.wizeline.capstoneproject.data.network

import android.util.Log
import com.jlhg.wizeline.capstoneproject.data.model.ListMoviesModel
import com.jlhg.wizeline.capstoneproject.data.model.MovieDetailsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiService @Inject constructor(private val apiClient: ApiClient) {

    suspend fun getTopRatedMovies(page: Int): ListMoviesModel? {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getTopRatedMovies(page = page)
            Log.d("tag", "getMovies code: ${response.code()}")
            response.body()
        }
    }

    suspend fun getNowPlayingMovies(page: Int): ListMoviesModel? {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getNowPlayingMovies(page = page)
            Log.d("tag", "getMovies code: ${response.code()}")
            response.body()
        }
    }

    suspend fun getLastestMovies(page: Int): ListMoviesModel? {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getLastestMovies(page = page)
            Log.d("tag", "getMovies code: ${response.code()}")
            response.body()
        }
    }

    suspend fun getMovieId(id: Int): MovieDetailsModel? {
        return withContext(Dispatchers.IO) {
            val response = apiClient.getMovieId(id)
            // TODO agregar control de errores
            response.body()
        }
    }


}