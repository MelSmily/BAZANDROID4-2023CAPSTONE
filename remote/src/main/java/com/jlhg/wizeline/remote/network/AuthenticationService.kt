package com.jlhg.wizeline.remote.network

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseUser
import com.jlhg.wizeline.remote.response.LoginResult
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AuthenticationService @Inject constructor(private val firebase: FirebaseClient) {

    suspend fun login(email: String, password: String): LoginResult = runCatching {
        firebase.auth.signInWithEmailAndPassword(email, password).await()
    }.toLoginResult()

    suspend fun createAccount(email: String, password: String): AuthResult? {
        return firebase.auth.createUserWithEmailAndPassword(email, password).await()
    }

    suspend fun logout() {
        firebase.auth.signOut()
    }

    suspend fun currentUser(): FirebaseUser? {
        return firebase.auth.currentUser
    }

    private fun Result<AuthResult>.toLoginResult() = when (getOrNull()) {
        null -> LoginResult.Error
        else -> LoginResult.Success
    }
}