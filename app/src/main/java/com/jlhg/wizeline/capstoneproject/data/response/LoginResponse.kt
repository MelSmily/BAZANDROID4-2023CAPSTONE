package com.jlhg.wizeline.capstoneproject.data.response

sealed class LoginResult {
    object Error : LoginResult()
    object Success: LoginResult()
}