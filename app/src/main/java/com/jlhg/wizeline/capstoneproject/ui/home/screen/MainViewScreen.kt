package com.jlhg.wizeline.capstoneproject.ui.home.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jlhg.wizeline.capstoneproject.ui.common.BottomNavItem
import com.jlhg.wizeline.capstoneproject.ui.component.TopBar
import com.jlhg.wizeline.capstoneproject.ui.home.HomeViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainViewScreen(homeViewModel: HomeViewModel) {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            TopBar {
                homeViewModel.logoutUser()
            }
        },
        bottomBar = { BottomNavigation(navController = navController) },
    ) {
        NavigationGraph(navController = navController, homeViewModel)
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavItem.NowPlaying,
        BottomNavItem.Latest,
        BottomNavItem.TopRated,
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = item.title,
                        modifier = Modifier
                            .height(24.dp)
                            .width(24.dp),
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 12.sp,
                    )
                },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.primary.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(0)
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, homeViewModel: HomeViewModel) {
    NavHost(navController, startDestination = BottomNavItem.NowPlaying.screen_route) {
        composable(BottomNavItem.NowPlaying.screen_route) {
            NowPlayingScreen(homeViewModel)
        }
        composable(BottomNavItem.Latest.screen_route) {
            LastestMovieScreen(homeViewModel)
        }
        composable(BottomNavItem.TopRated.screen_route) {
            TopRatedScreen(homeViewModel)
        }
    }
}
