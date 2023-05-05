package com.jlhg.wizeline.remote.model

sealed class LoginResult {
    object Error : LoginResult()
    object Success : LoginResult()
}
