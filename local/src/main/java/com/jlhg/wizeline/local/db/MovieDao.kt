package com.jlhg.wizeline.local.db

import androidx.room.*
import com.jlhg.wizeline.local.db.entities.LastestMoviesEntity
import com.jlhg.wizeline.local.db.entities.MovieDetailsEntity
import com.jlhg.wizeline.local.db.entities.NowPlayingMoviesEntity
import com.jlhg.wizeline.local.db.entities.TopRatedMoviesEntity

@Dao
interface MovieDao {
    @Query("SELECT * FROM now_playing ORDER BY id DESC")
    suspend fun getNowPlayingMovies(): List<NowPlayingMoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNowPlayingMovies(movies: List<NowPlayingMoviesEntity>)

    @Query("SELECT * FROM top_rated ORDER BY id DESC")
    suspend fun getTopRatedMovies(): List<TopRatedMoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTopRatedMovies(movies: List<TopRatedMoviesEntity>)

    @Query("SELECT * FROM lastest ORDER BY id DESC")
    suspend fun getLastestMovies(): List<LastestMoviesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLastestMovies(movies: List<LastestMoviesEntity>)

    @Query("SELECT * FROM movie_details WHERE id = :id")
    suspend fun getMovieDetails(id: Int): MovieDetailsEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetails(movieDetails: MovieDetailsEntity)
}
