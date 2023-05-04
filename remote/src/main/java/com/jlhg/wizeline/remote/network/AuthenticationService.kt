package com.jlhg.wizeline.remote.network

import com.google.firebase.auth.AuthResult
import com.jlhg.wizeline.remote.response.LoginResult
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.tasks.await

@Singleton
class AuthenticationService @Inject constructor(private val firebase: FirebaseClient) {

    suspend fun login(email: String, password: String): LoginResult = runCatching {
        firebase.auth.signInWithEmailAndPassword(email, password).await()
    }.toLoginResult()

    suspend fun createAccount(email: String, password: String): Boolean {
        val auth = firebase.auth.createUserWithEmailAndPassword(email, password).await()
        return auth != null
    }

    fun logout() {
        firebase.auth.signOut()
    }

    fun currentUser(): Boolean {
        val user = firebase.auth.currentUser
        return user != null
    }

    private fun Result<AuthResult>.toLoginResult() = when (getOrNull()) {
        null -> LoginResult.Error
        else -> LoginResult.Success
    }
}
