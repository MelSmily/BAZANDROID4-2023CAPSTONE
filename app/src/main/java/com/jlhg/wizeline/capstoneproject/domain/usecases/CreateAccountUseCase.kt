package com.jlhg.wizeline.capstoneproject.domain.usecases

import com.jlhg.wizeline.capstoneproject.data.network.AuthenticationService
import javax.inject.Inject

class CreateAccountUseCase @Inject constructor(
    private val authenticationService: AuthenticationService,
) {

    suspend operator fun invoke(email: String, password: String): Boolean {
        return authenticationService.createAccount(email, password) != null
    }
}