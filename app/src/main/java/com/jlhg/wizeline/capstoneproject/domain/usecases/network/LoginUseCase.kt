package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.remote.network.AuthenticationService
import com.jlhg.wizeline.remote.response.LoginResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val authenticationService: com.jlhg.wizeline.remote.network.AuthenticationService) {

    suspend operator fun invoke(email: String, password: String): com.jlhg.wizeline.remote.response.LoginResult =
        authenticationService.login(email, password)

}