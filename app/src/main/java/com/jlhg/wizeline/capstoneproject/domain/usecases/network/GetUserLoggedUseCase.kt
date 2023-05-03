package com.jlhg.wizeline.capstoneproject.domain.usecases.network

import com.jlhg.wizeline.remote.network.AuthenticationService
import javax.inject.Inject

class GetUserLoggedUseCase @Inject constructor(private val authenticationService: com.jlhg.wizeline.remote.network.AuthenticationService) {

    suspend operator fun invoke(): Boolean{
       return authenticationService.currentUser() != null
    }

}