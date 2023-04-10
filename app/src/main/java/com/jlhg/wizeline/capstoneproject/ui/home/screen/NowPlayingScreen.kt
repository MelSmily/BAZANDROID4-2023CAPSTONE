package com.jlhg.wizeline.capstoneproject.ui.home.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.jlhg.wizeline.capstoneproject.R
import com.jlhg.wizeline.capstoneproject.domain.model.MovieItem
import com.jlhg.wizeline.capstoneproject.ui.common.ApiStatus
import com.jlhg.wizeline.capstoneproject.ui.component.Loader
import com.jlhg.wizeline.capstoneproject.ui.component.MovieListItem
import com.jlhg.wizeline.capstoneproject.ui.home.HomeViewModel


@SuppressLint("ResourceType")
@Composable
fun NowPlayingScreen(homeViewModel: HomeViewModel) {
    LaunchedEffect(Unit) {
        homeViewModel.getPopularMovies()
    }
    val status: ApiStatus by homeViewModel.status.observeAsState(initial = ApiStatus.LOADING)
    val movies: List<MovieItem> by homeViewModel.moviesList.observeAsState(listOf())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        when (status) {
            ApiStatus.SUCCESS -> {
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(150.dp),
                    contentPadding = PaddingValues(10.dp)
                ) {
                    items(movies) {item ->
                        MovieListItem(item)
                    }
                }
            }
            ApiStatus.LOADING -> {
                Loader()
            }
            ApiStatus.ERROR -> {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}