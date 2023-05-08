package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.capstoneproject.utils.Utils.email
import com.jlhg.wizeline.capstoneproject.utils.Utils.pass
import com.jlhg.wizeline.remote.network.AuthenticationService
import org.junit.Before
import io.mockk.*
import io.reactivex.rxjava3.core.Completable
import org.junit.After
import org.junit.Test

class LoginUseCaseTest{

    private val mockAuthenticationService = mockk<AuthenticationService>(relaxed = true)
    private lateinit var loginUseCase: LoginUseCase

    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)
        loginUseCase = LoginUseCase(mockAuthenticationService)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `invoke and sign in with email firebase`() = run {
        //Given
        every { loginUseCase.invoke(email, pass) } returns Completable.complete()
        //When
        mockAuthenticationService.signInWithEmail(email, pass)
        //Then
        verify(exactly = 1) { mockAuthenticationService.signInWithEmail(email, pass) }
    }

    @Test
    fun `invoke and not sign in with email firebase`() = run {
        //Given
        every { loginUseCase.invoke(email, pass) } returns Completable.error(Exception("Failed to login"))
        //When
        mockAuthenticationService.signInWithEmail(email, pass)
        //Then
        verify(exactly = 1) { mockAuthenticationService.signInWithEmail(email, pass) }
    }
}