package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.google.common.truth.Truth.assertThat
import com.jlhg.wizeline.capstoneproject.utils.Utils
import com.jlhg.wizeline.remote.model.MovieDetailsModel
import com.jlhg.wizeline.remote.network.MovieRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetDetailsUseCaseTest {

    private val mockMovieRepository = mockk<MovieRepository>(relaxed = true)
    private lateinit var getDetailsUseCase: GetDetailsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getDetailsUseCase = GetDetailsUseCase(mockMovieRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `get movie details`() = runBlocking {
        //Given
        coEvery { getDetailsUseCase.getDetails(1) } returns Utils.createMovieDetails()
        //When
        val response = mockMovieRepository.getDetailsMovie(1)
        //Then
        coVerify(exactly = 1) { mockMovieRepository.getDetailsMovie(1) }
        assertThat(response).isInstanceOf(MovieDetailsModel::class.java)
    }
}