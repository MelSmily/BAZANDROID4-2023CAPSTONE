package com.jlhg.wizeline.local.db

import com.jlhg.wizeline.local.db.entities.LastestMoviesEntity
import com.jlhg.wizeline.local.db.entities.MovieDetailsEntity
import com.jlhg.wizeline.local.db.entities.NowPlayingMoviesEntity
import com.jlhg.wizeline.local.db.entities.TopRatedMoviesEntity
import javax.inject.Inject

class DatabaseRepository @Inject constructor(
    private val movieDao: MovieDao
) {
    suspend fun getNowPlayingMovies(): List<NowPlayingMoviesEntity>{
        return movieDao.getNowPlayingMovies()
    }

    suspend fun insertNowPlayingMovies(movies: List<NowPlayingMoviesEntity>){
        movieDao.insertNowPlayingMovies(movies)
    }

    suspend fun getTopRatedMovies(): List<TopRatedMoviesEntity>{
        return movieDao.getTopRatedMovies()
    }

    suspend fun insertTopRatedMovies(movies: List<TopRatedMoviesEntity>){
        movieDao.insertTopRatedMovies(movies)
    }

    suspend fun getLastestMovies(): List<LastestMoviesEntity>{
        return movieDao.getLastestMovies()
    }

    suspend fun insertLastestMovies(movies: List<LastestMoviesEntity>){
        movieDao.insertLastestMovies(movies)
    }

    suspend fun getMovieDetails(id: Int): MovieDetailsEntity?{
        return movieDao.getMovieDetails(id)
    }

    suspend fun insertMovieDetails(movieDetails: MovieDetailsEntity){
        movieDao.insertMovieDetails(movieDetails)
    }
}