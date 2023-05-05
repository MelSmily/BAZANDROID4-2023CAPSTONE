package com.jlhg.wizeline.capstoneproject.ui.home.screen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.jlhg.wizeline.capstoneproject.domain.model.MovieItem
import com.jlhg.wizeline.capstoneproject.ui.common.ApiStatus
import com.jlhg.wizeline.capstoneproject.ui.component.ErrorAnimation
import com.jlhg.wizeline.capstoneproject.ui.component.Loader
import com.jlhg.wizeline.capstoneproject.ui.component.MovieListItem
import com.jlhg.wizeline.capstoneproject.ui.detail.DetailActivity
import com.jlhg.wizeline.capstoneproject.ui.detail.DetailActivity.Companion.MOVIE_ID
import com.jlhg.wizeline.capstoneproject.ui.home.HomeViewModel

@SuppressLint("ResourceType")
@Composable
fun NowPlayingScreen(homeViewModel: HomeViewModel) {
    LaunchedEffect(Unit) {
        homeViewModel.getNowPlayingMovies()
    }
    val context = LocalContext.current
    val status: ApiStatus by homeViewModel.status.observeAsState(initial = ApiStatus.LOADING)
    val movies: List<MovieItem> by homeViewModel.moviesList.observeAsState(listOf())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
    ) {
        when (status) {
            ApiStatus.SUCCESS -> {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(150.dp),
                    contentPadding = PaddingValues(10.dp),
                ) {
                    items(movies) { item ->
                        MovieListItem(item) {
                            val intent = Intent(context, DetailActivity::class.java)
                            intent.putExtra(MOVIE_ID, it)
                            context.startActivity(intent)
                        }
                    }
                }
            }
            ApiStatus.LOADING -> {
                Loader()
            }
            ApiStatus.ERROR -> {
                ErrorAnimation()
            }
        }
    }
}
