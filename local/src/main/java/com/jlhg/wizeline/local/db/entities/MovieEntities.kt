package com.jlhg.wizeline.local.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "now_playing")
data class NowPlayingMoviesEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val posterPath: String
)

@Entity(tableName = "top_rated")
data class TopRatedMoviesEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val posterPath: String
)

@Entity(tableName = "lastest")
data class LastestMoviesEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val posterPath: String
)