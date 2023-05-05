package com.jlhg.wizeline.capstoneproject.domain.usecases.db

import com.jlhg.wizeline.capstoneproject.domain.model.Gender
import com.jlhg.wizeline.capstoneproject.domain.model.MovieDetail
import com.jlhg.wizeline.capstoneproject.domain.model.toDomain
import com.jlhg.wizeline.local.db.DatabaseRepository
import javax.inject.Inject

class GetMovieDetailsFromDBUseCase @Inject constructor(
    private val databaseRepository: DatabaseRepository,
) {
    suspend fun getMovieDetails(id: Int): MovieDetail? {
        return databaseRepository.getMovieDetails(id)?.toDomain()
    }

    suspend fun getMovieGenders(id: Int): List<Gender> {
        return databaseRepository.getMovieGenders(id).map { it.toDomain() }
    }
}
