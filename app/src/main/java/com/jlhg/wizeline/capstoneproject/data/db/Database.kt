package com.jlhg.wizeline.capstoneproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jlhg.wizeline.capstoneproject.data.db.converters.GenderConverter
import com.jlhg.wizeline.capstoneproject.data.db.converters.LanguageConverter
import com.jlhg.wizeline.capstoneproject.data.db.entities.LastestMoviesEntity
import com.jlhg.wizeline.capstoneproject.data.db.entities.MovieDetailsEntity
import com.jlhg.wizeline.capstoneproject.data.db.entities.NowPlayingMoviesEntity
import com.jlhg.wizeline.capstoneproject.data.db.entities.TopRatedMoviesEntity

@Database(entities = [NowPlayingMoviesEntity::class, TopRatedMoviesEntity::class, LastestMoviesEntity::class, MovieDetailsEntity::class], version = 1, exportSchema = false)
@TypeConverters(GenderConverter::class, LanguageConverter::class)
abstract class Database: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}