package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.remote.network.AuthenticationService
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authenticationService: AuthenticationService,
) {

    operator fun invoke(email: String, password: String): Completable =
        authenticationService.signInWithEmail(email, password)
}
