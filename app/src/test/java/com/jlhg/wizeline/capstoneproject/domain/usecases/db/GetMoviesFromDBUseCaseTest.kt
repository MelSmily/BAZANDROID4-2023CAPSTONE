package com.jlhg.wizeline.capstoneproject.domain.usecases.db

import com.google.common.truth.Truth.assertThat
import com.jlhg.wizeline.capstoneproject.utils.Utils
import com.jlhg.wizeline.local.db.DatabaseRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetMoviesFromDBUseCaseTest {

    private val mockDatabaseRepository = mockk<DatabaseRepository>(relaxed = true)
    private lateinit var getMoviesFromDBUseCase: GetMoviesFromDBUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getMoviesFromDBUseCase = GetMoviesFromDBUseCase(mockDatabaseRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun getNowPlayingMovies(): Unit = runBlocking {
        //Given
        coEvery { getMoviesFromDBUseCase.getNowPlayingMovies() } returns Utils.createMutableListMovieItem()
        //When
        val response = mockDatabaseRepository.getNowPlayingMovies()
        //Then
        coVerify(exactly = 1) { mockDatabaseRepository.getNowPlayingMovies() }
        assertThat(response).isNotEmpty()
    }

    @Test
    fun getTopRatedMovies(): Unit = runBlocking {
        //Given
        coEvery { getMoviesFromDBUseCase.getTopRatedMovies() } returns Utils.createMutableListMovieItem()
        //When
        val response = mockDatabaseRepository.getTopRatedMovies()
        //Then
        coVerify(exactly = 1) { mockDatabaseRepository.getTopRatedMovies() }
        assertThat(response).isNotEmpty()
    }

    @Test
    fun getLastestMovies() : Unit = runBlocking {
        //Given
        coEvery { getMoviesFromDBUseCase.getLastestMovies() } returns Utils.createMutableListMovieItem()
        //When
        val response = mockDatabaseRepository.getLastestMovies()
        //Then
        coVerify(exactly = 1) { mockDatabaseRepository.getLastestMovies() }
        assertThat(response).isNotEmpty()
    }
}