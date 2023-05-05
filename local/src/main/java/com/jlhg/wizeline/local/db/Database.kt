package com.jlhg.wizeline.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.jlhg.wizeline.local.db.converters.GenderConverter
import com.jlhg.wizeline.local.db.converters.LanguageConverter
import com.jlhg.wizeline.local.db.entities.GenderEntity
import com.jlhg.wizeline.local.db.entities.LastestMoviesEntity
import com.jlhg.wizeline.local.db.entities.MovieDetailsEntity
import com.jlhg.wizeline.local.db.entities.NowPlayingMoviesEntity
import com.jlhg.wizeline.local.db.entities.TopRatedMoviesEntity

@Database(
    entities = [
        NowPlayingMoviesEntity::class, TopRatedMoviesEntity::class,
        LastestMoviesEntity::class, MovieDetailsEntity::class,
        GenderEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
@TypeConverters(GenderConverter::class, LanguageConverter::class)
abstract class Database : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
