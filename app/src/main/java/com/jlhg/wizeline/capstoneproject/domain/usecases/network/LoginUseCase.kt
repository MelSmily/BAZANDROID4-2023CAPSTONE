package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.remote.model.LoginResult
import com.jlhg.wizeline.remote.network.AuthenticationService
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationService: AuthenticationService,
) {

    suspend operator fun invoke(email: String, password: String): LoginResult =
        authenticationService.login(email, password)
}
