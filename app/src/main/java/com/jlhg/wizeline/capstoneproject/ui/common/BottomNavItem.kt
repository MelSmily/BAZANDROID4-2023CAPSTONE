package com.jlhg.wizeline.capstoneproject.ui.common

import com.jlhg.wizeline.capstoneproject.R

sealed class BottomNavItem(var title: String, var icon: Int, var screen_route: String) {

    object NowPlaying : BottomNavItem("Now Playing", R.drawable.ic_playing_movie, "NowPlaying")
    object Latest : BottomNavItem("Latest", R.drawable.ic_lastest_movie, "Latest")
    object TopRated : BottomNavItem("Top Rated", R.drawable.ic_top_rated, "TopRated")
}
