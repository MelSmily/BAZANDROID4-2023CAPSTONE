package com.jlhg.wizeline.capstoneproject.domain.usecases.db

import com.jlhg.wizeline.local.db.DatabaseRepository
import com.jlhg.wizeline.capstoneproject.domain.model.MovieDetail
import com.jlhg.wizeline.capstoneproject.domain.model.toMovieDetailsEntity
import javax.inject.Inject

class InsertMovieDetailsToDBUseCase @Inject constructor(private val databaseRepository: com.jlhg.wizeline.local.db.DatabaseRepository) {
    suspend fun insertMovieDetails(movieDetails: MovieDetail){
        databaseRepository.insertMovieDetails(movieDetails.toMovieDetailsEntity())
    }
}