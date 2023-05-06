package com.jlhg.wizeline.remote.network

import io.reactivex.rxjava3.core.Completable
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationService @Inject constructor(private val firebase: FirebaseClient) {

    fun signInWithEmail(email: String, password: String): Completable {
        return Completable.create { emitter ->
            firebase.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    emitter.onComplete()
                } else {
                    emitter.onError(task.exception ?: Exception("Failed to login"))
                }
            }
        }
    }

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
}
