package com.jlhg.wizeline.capstoneproject.domain.usecases.db

import com.jlhg.wizeline.capstoneproject.utils.Utils
import com.jlhg.wizeline.local.db.DatabaseRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class InsertMovieDetailsToDBUseCaseTest {

    private val mockDatabaseRepository = mockk<DatabaseRepository>(relaxed = true)
    private lateinit var insertMovieDetailsToDBUseCase: InsertMovieDetailsToDBUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        insertMovieDetailsToDBUseCase = InsertMovieDetailsToDBUseCase(mockDatabaseRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun insertMovieDetails() = runBlocking {
        //Given
        coEvery { insertMovieDetailsToDBUseCase.insertMovieDetails(Utils.createMovieDetails()) } returns Unit
        //When
        mockDatabaseRepository.insertMovieDetails(Utils.createMovieDetailsEntity())
        //Then
        coVerify(exactly = 1) { mockDatabaseRepository.insertMovieDetails(Utils.createMovieDetailsEntity()) }
    }
}