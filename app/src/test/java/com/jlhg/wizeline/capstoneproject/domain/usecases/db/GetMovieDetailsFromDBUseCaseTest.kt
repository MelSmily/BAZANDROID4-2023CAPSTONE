package com.jlhg.wizeline.capstoneproject.domain.usecases.db

import com.google.common.truth.Truth.assertThat
import com.jlhg.wizeline.capstoneproject.utils.Utils
import com.jlhg.wizeline.local.db.DatabaseRepository
import com.jlhg.wizeline.local.db.entities.MovieDetailsEntity
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetMovieDetailsFromDBUseCaseTest {

    private val mockDatabaseRepository = mockk<DatabaseRepository>(relaxed = true)
    private lateinit var getMovieDetailsFromDBUseCase: GetMovieDetailsFromDBUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getMovieDetailsFromDBUseCase = GetMovieDetailsFromDBUseCase(mockDatabaseRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `get movie details`(): Unit = runBlocking {
        //Given
        coEvery { getMovieDetailsFromDBUseCase.getMovieDetails(1) } returns Utils.createMovieDetails()
        //When
        val response = mockDatabaseRepository.getMovieDetails(1)
        //Then
        coVerify(exactly = 1) { mockDatabaseRepository.getMovieDetails(1) }
        assertThat(response).isInstanceOf(MovieDetailsEntity::class.java)
    }

    @Test
    fun `get movie genders`() = runBlocking {
        //Given
        coEvery { getMovieDetailsFromDBUseCase.getMovieGenders(1) } returns Utils.createListGenders()
        //When
        val response = mockDatabaseRepository.getMovieGenders(1)
        //Then
        coVerify(exactly = 1) { mockDatabaseRepository.getMovieGenders(1) }
        assertThat(response).isNotEmpty()
    }
}