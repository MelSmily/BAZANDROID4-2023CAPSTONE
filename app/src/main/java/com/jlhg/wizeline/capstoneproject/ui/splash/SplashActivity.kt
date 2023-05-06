package com.jlhg.wizeline.capstoneproject.ui.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.jlhg.wizeline.capstoneproject.ui.splash.screen.SplashScreen
import com.jlhg.wizeline.capstoneproject.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                SplashScreen(splashViewModel)
            }
        }
    }
}
