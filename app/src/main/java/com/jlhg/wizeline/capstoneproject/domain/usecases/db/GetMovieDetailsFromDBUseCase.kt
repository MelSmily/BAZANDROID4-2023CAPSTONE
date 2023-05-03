package com.jlhg.wizeline.capstoneproject.domain.usecases.db

import com.jlhg.wizeline.capstoneproject.local.db.DatabaseRepository
import com.jlhg.wizeline.capstoneproject.domain.model.MovieDetail
import com.jlhg.wizeline.capstoneproject.domain.model.toDomain
import javax.inject.Inject

class GetMovieDetailsFromDBUseCase @Inject constructor(private val databaseRepository: DatabaseRepository) {
    suspend fun getMovieDetails(id: Int): MovieDetail?{
        return databaseRepository.getMovieDetails(id)?.toDomain()
    }
}