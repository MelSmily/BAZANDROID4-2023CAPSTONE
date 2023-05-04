package com.jlhg.wizeline.remote.response

sealed class LoginResult {
    object Error : LoginResult()
    object Success : LoginResult()
}
