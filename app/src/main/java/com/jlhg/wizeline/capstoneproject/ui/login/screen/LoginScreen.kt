package com.jlhg.wizeline.capstoneproject.ui.login.screen

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jlhg.wizeline.capstoneproject.R
import com.jlhg.wizeline.capstoneproject.ui.component.*
import com.jlhg.wizeline.capstoneproject.ui.home.HomeActivity
import com.jlhg.wizeline.capstoneproject.ui.login.LoginRoutes
import com.jlhg.wizeline.capstoneproject.ui.login.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel, navController: NavHostController) {
    val context = LocalContext.current
    val goToHome: Boolean by loginViewModel.goToHome.observeAsState(initial = false)
    val isLoading: Boolean by loginViewModel.isLoading.observeAsState(initial = false)
    val showErrorDialog: Boolean by loginViewModel.showErrorDialog.observeAsState(initial = false)
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Body(
            Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            loginViewModel
        )
        Footer(Modifier.align(Alignment.BottomCenter), navController)
        if (isLoading) {
            Loader()
        }
        if (showErrorDialog) {
            ErrorDialog(
                stringResource(R.string.login_error_dialog_title),
                stringResource(R.string.login_error_dialog_body)
            ) {
                loginViewModel.setShowErrorDialog(false)
            }
        }
        if (goToHome) {
            loginViewModel.cleanData()
            context.startActivity(Intent(context, HomeActivity::class.java))
            (context as Activity).finish()
        }
    }
}

@Composable
private fun Footer(modifier: Modifier, navController: NavHostController) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .background(MaterialTheme.colors.primary)
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        SignUp(navController)
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
private fun SignUp(navController: NavHostController) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            text = stringResource(id = R.string.login_footer_unselected),
            fontSize = 12.sp,
            color = MaterialTheme.colors.secondary
        )
        Text(
            text = stringResource(id = R.string.login_footer_selected),
            Modifier
                .padding(horizontal = 8.dp)
                .clickable(
                    onClick = {
                        navController.navigate(LoginRoutes.Signin.route)
                    }
                ),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        )
    }
}

@Composable
private fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val isLoginEnable: Boolean by loginViewModel.isLoginEnable.observeAsState(initial = false)

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        EmailField(email) {
            loginViewModel.onLoginChanged(email = it, password = password)
        }
        Spacer(modifier = Modifier.size(4.dp))
        PasswordField(password) {
            loginViewModel.onLoginChanged(email = email, password = it)
        }
        Spacer(modifier = Modifier.size(16.dp))
        SignInButton(stringResource(id = R.string.login_button_login), isLoginEnable) {
            loginViewModel.loginUser()
        }
    }
}
