package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.remote.network.AuthenticationService
import javax.inject.Inject

class LogoutUseCase @Inject constructor(
    private val authenticationService: AuthenticationService,
) {

    operator fun invoke() {
        authenticationService.logout()
    }
}
