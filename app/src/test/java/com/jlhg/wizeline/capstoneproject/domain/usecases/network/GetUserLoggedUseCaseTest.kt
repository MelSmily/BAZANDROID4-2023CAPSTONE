package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.remote.network.AuthenticationService
import io.mockk.*
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class GetUserLoggedUseCaseTest {

    private val mockAuthenticationService = mockk<AuthenticationService>(relaxed = true)
    private lateinit var getUserLoggedUseCase: GetUserLoggedUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        getUserLoggedUseCase = GetUserLoggedUseCase(mockAuthenticationService)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `invoke and is logged current user firebase`() = run {
        //Given
        every { getUserLoggedUseCase.invoke() } returns true
        //When
        mockAuthenticationService.currentUser()
        //Then
        verify(exactly = 1) { mockAuthenticationService.currentUser() }
    }

    @Test
    fun `invoke and is not logged current user firebase`() = run {
        //Given
        every { getUserLoggedUseCase.invoke() } returns false
        //When
        mockAuthenticationService.currentUser()
        //Then
        verify(exactly = 1) { mockAuthenticationService.currentUser() }
    }
}