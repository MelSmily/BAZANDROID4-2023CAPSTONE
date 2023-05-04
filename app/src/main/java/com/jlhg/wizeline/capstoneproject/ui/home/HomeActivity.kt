package com.jlhg.wizeline.capstoneproject.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.jlhg.wizeline.capstoneproject.ui.home.screen.MainViewScreen
import com.jlhg.wizeline.capstoneproject.ui.login.LoginActivity
import com.jlhg.wizeline.capstoneproject.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                val goToLogin: Boolean by homeViewModel.goToLogin.observeAsState(initial = false)
                if (goToLogin) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
                MainViewScreen(homeViewModel)
            }
        }
    }
}
