package com.jlhg.wizeline.capstoneproject.ui.splash.screen

import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import com.jlhg.wizeline.capstoneproject.ui.home.HomeActivity
import com.jlhg.wizeline.capstoneproject.ui.login.LoginActivity
import com.jlhg.wizeline.capstoneproject.ui.splash.SplashViewModel

@Composable
fun SplashScreen(splashViewModel: SplashViewModel) {
    val context = LocalContext.current
    val goToHome: Boolean by splashViewModel.goToHome.observeAsState(initial = false)
    val goToLogin: Boolean by splashViewModel.goToLogin.observeAsState(initial = false)

    if (goToHome) {
        context.startActivity(Intent(context, HomeActivity::class.java))
        (context as Activity).finish()
    }
    if (goToLogin) {
        context.startActivity(Intent(context, LoginActivity::class.java))
        (context as Activity).finish()
    }
}
