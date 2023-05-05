package com.jlhg.wizeline.local.di

import android.content.Context
import androidx.room.Room
import com.jlhg.wizeline.local.db.Database
import com.jlhg.wizeline.local.db.MovieDao
import com.jlhg.wizeline.local.db.converters.GenderConverter
import com.jlhg.wizeline.local.db.converters.LanguageConverter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): Database =
        Room.databaseBuilder(
            context,
            Database::class.java,
            "movies.db",
        ).addTypeConverter(GenderConverter())
            .addTypeConverter(LanguageConverter())
            .build()

    @Provides
    fun providesMovieDao(database: Database): MovieDao =
        database.movieDao()
}
