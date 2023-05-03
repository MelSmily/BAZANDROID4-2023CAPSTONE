package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.remote.network.AuthenticationService
import javax.inject.Inject

class CreateAccountUseCase @Inject constructor(
    private val authenticationService: com.jlhg.wizeline.remote.network.AuthenticationService,
) {

    suspend operator fun invoke(email: String, password: String): Boolean {
        return authenticationService.createAccount(email, password) != null
    }
}