package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.remote.network.AuthenticationService
import io.mockk.*
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class LogoutUseCaseTest {

    private val mockAuthenticationService = mockk<AuthenticationService>(relaxed = true)
    private lateinit var logoutUseCase: LogoutUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        logoutUseCase = LogoutUseCase(mockAuthenticationService)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `invoke logout firebase`() = run {
        //Given
        every { logoutUseCase.invoke() } returns Unit
        //When
        mockAuthenticationService.logout()
        //Then
        verify(exactly = 1) { mockAuthenticationService.logout() }
    }
}