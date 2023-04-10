package com.jlhg.wizeline.capstoneproject.domain.usecases

import com.jlhg.wizeline.capstoneproject.data.network.MovieRepository
import com.jlhg.wizeline.capstoneproject.domain.model.MovieDetailsItem
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend fun getDetails(id: Int): MovieDetailsItem? {
        return movieRepository.getDetailsMovie(id)
    }
}