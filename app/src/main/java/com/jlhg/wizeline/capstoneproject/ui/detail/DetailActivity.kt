package com.jlhg.wizeline.capstoneproject.ui.detail

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.jlhg.wizeline.capstoneproject.ui.home.HomeViewModel
import com.jlhg.wizeline.capstoneproject.ui.home.screen.MainViewScreen
import com.jlhg.wizeline.capstoneproject.ui.login.LoginActivity
import com.jlhg.wizeline.capstoneproject.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {
    private val detailsViewModel: DetailsViewModel by viewModels()

    private var movieId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieId = intent.getIntExtra(MOVIE_ID, movieId)
        setContent {
            MoviesTheme {
                DetailScreen(detailsViewModel, movieId)
            }
        }
    }

    companion object {
        const val MOVIE_ID = "MOVIE_ID"
    }
}