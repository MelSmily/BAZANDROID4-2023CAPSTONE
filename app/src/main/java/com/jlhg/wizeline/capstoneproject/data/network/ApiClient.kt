package com.jlhg.wizeline.capstoneproject.data.network

import com.jlhg.wizeline.capstoneproject.BuildConfig
import com.jlhg.wizeline.capstoneproject.data.model.ListMoviesModel
import com.jlhg.wizeline.capstoneproject.data.model.MovieDetailsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiClient {

    @GET(value = "movie/now_playing?")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "es-ES",
        @Query("page") page: Int = 1
    ): Response<ListMoviesModel>

    @GET(value = "movie/upcoming?")
    suspend fun getLastestMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "es-ES",
        @Query("page") page: Int = 1
    ): Response<ListMoviesModel>

    @GET(value = "movie/top_rated?")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "es-ES",
        @Query("page") page: Int = 1
    ): Response<ListMoviesModel>

    @GET("movie/{movieId}?")
    suspend fun getMovieId(
        @Path("movieId") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.TMDB_API_KEY,
        @Query("language") language: String = "es-ES",
    ): Response<MovieDetailsModel>
}