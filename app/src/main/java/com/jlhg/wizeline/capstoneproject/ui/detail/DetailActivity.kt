package com.jlhg.wizeline.capstoneproject.ui.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
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
