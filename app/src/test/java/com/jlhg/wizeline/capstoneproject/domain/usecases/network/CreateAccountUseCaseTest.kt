package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.capstoneproject.utils.Utils.email
import com.jlhg.wizeline.capstoneproject.utils.Utils.pass
import com.jlhg.wizeline.remote.network.AuthenticationService
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class CreateAccountUseCaseTest {

    private val mockAuthenticationService = mockk<AuthenticationService>(relaxed = true)
    private lateinit var createAccountUseCase: CreateAccountUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        createAccountUseCase = CreateAccountUseCase(mockAuthenticationService)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `create account success use case`() = runBlocking {
        //Given
        coEvery { createAccountUseCase.invoke(email, pass) } returns true
        //When
        mockAuthenticationService.createAccount(email, pass)
        //Then
        coVerify(exactly = 1) { mockAuthenticationService.createAccount(email, pass) }
    }

    @Test
    fun `create account error use case`() = runBlocking {
        //Given
        coEvery { createAccountUseCase.invoke(email, pass) } returns false
        //When
        mockAuthenticationService.createAccount(email, pass)
        //Then
        coVerify(exactly = 1) { mockAuthenticationService.createAccount(email, pass) }
    }
}