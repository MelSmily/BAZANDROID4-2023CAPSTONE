package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.capstoneproject.data.network.MovieRepository
import com.jlhg.wizeline.capstoneproject.domain.model.MovieDetail
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    suspend fun getDetails(id: Int): MovieDetail? {
        return movieRepository.getDetailsMovie(id)
    }
}