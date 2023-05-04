package com.jlhg.wizeline.capstoneproject.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jlhg.wizeline.capstoneproject.ui.login.screen.LoginScreen
import com.jlhg.wizeline.capstoneproject.ui.login.screen.SignInScreen
import com.jlhg.wizeline.capstoneproject.ui.theme.MoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private val loginViewModel: LoginViewModel by viewModels()
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = LoginRoutes.Login.route,
                ) {
                    composable(LoginRoutes.Login.route) {
                        LoginScreen(loginViewModel, navController)
                    }
                    composable(LoginRoutes.Signin.route) {
                        SignInScreen(loginViewModel, navController)
                    }
                }
            }
        }
    }
}

sealed class LoginRoutes(val route: String) {
    object Login : LoginRoutes("Login")
    object Signin : LoginRoutes("Signin")
}
