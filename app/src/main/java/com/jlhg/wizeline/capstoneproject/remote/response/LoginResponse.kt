package com.jlhg.wizeline.capstoneproject.remote.response

sealed class LoginResult {
    object Error : LoginResult()
    object Success: LoginResult()
}