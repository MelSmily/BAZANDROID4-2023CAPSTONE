package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.google.common.truth.Truth.assertThat
import com.jlhg.wizeline.capstoneproject.utils.Utils
import com.jlhg.wizeline.remote.network.MovieRepository
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class GetMoviesUseCaseTest {

    private val mockMovieRepository = mockk<MovieRepository>(relaxed = true)
    private lateinit var getMoviesUseCase: GetMoviesUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getMoviesUseCase = GetMoviesUseCase(mockMovieRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `get Top Rated Movies`(): Unit = runBlocking {
        //Given
        coEvery { getMoviesUseCase.getTopRatedMovies(Utils.page) } returns Utils.createMutableListMovieItem()
        //When
        val response = mockMovieRepository.getTopRatedMovies(Utils.page)
        //Then
        coVerify(exactly = 1) { mockMovieRepository.getTopRatedMovies(Utils.page) }
        assertThat(response!!.results).isNotEmpty()
    }

    @Test
    fun `get Now Playing Movies`() = runBlocking {
        //Given
        coEvery { getMoviesUseCase.getNowPlayingMovies(Utils.page) } returns Utils.createMutableListMovieItem()
        //When
        val response = mockMovieRepository.getNowPlayingMovies(Utils.page)
        //Then
        coVerify(exactly = 1) { mockMovieRepository.getNowPlayingMovies(Utils.page) }
        assertThat(response!!.results).isNotEmpty()
    }

    @Test
    fun `get Lastest Movies`() = runBlocking {
        //Given
        coEvery { getMoviesUseCase.getLastestMovies(Utils.page) } returns Utils.createMutableListMovieItem()
        //When
        val response = mockMovieRepository.getLastestMovies(Utils.page)
        //Then
        coVerify(exactly = 1) { mockMovieRepository.getLastestMovies(Utils.page) }
        assertThat(response!!.results).isNotEmpty()
    }
}