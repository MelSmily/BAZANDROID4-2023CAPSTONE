package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.capstoneproject.domain.model.MovieDetail
import com.jlhg.wizeline.capstoneproject.domain.model.toDomain
import com.jlhg.wizeline.remote.network.MovieRepository
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(
    private val movieRepository: com.jlhg.wizeline.remote.network.MovieRepository,
) {

    suspend fun getDetails(id: Int): MovieDetail? {
        val response = movieRepository.getDetailsMovie(id)
        return response?.toDomain()
    }
}
