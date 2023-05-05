package com.jlhg.wizeline.capstoneproject.ui.login.screen

import android.app.Activity
import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jlhg.wizeline.capstoneproject.R
import com.jlhg.wizeline.capstoneproject.ui.component.EmailField
import com.jlhg.wizeline.capstoneproject.ui.component.ErrorDialog
import com.jlhg.wizeline.capstoneproject.ui.component.ImageLogo
import com.jlhg.wizeline.capstoneproject.ui.component.Loader
import com.jlhg.wizeline.capstoneproject.ui.component.PasswordField
import com.jlhg.wizeline.capstoneproject.ui.component.SignInButton
import com.jlhg.wizeline.capstoneproject.ui.home.HomeActivity
import com.jlhg.wizeline.capstoneproject.ui.login.LoginViewModel

@Composable
fun SignInScreen(loginViewModel: LoginViewModel, navController: NavHostController) {
    val context = LocalContext.current
    val goToHome: Boolean by loginViewModel.goToHome.observeAsState(initial = false)
    val isLoading: Boolean by loginViewModel.isLoading.observeAsState(initial = false)
    val showErrorDialog: Boolean by loginViewModel.showErrorDialog.observeAsState(initial = false)
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    ) {
        Body(
            Modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp),
            loginViewModel,
        )
        if (isLoading) {
            Loader()
        }
        if (showErrorDialog) {
            ErrorDialog(
                stringResource(R.string.signin_error_dialog_title),
                stringResource(R.string.signin_error_dialog_body),
            ) {
                loginViewModel.setShowErrorDialog(false)
            }
        }
        if (goToHome) {
            context.startActivity(Intent(context, HomeActivity::class.java))
            (context as Activity).finish()
        }
    }
    BackHandler {
        loginViewModel.cleanData()
        navController.navigateUp()
    }
}

@Composable
private fun Body(modifier: Modifier, loginViewModel: LoginViewModel) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")
    val passwordConfirm: String by loginViewModel.passwordConfirm.observeAsState(initial = "")
    val isSigninEnable: Boolean by loginViewModel.isSigninEnable.observeAsState(initial = false)

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        EmailField(email) {
            loginViewModel.onSigninChanged(
                email = it,
                password = password,
                passwordConfirm = passwordConfirm,
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        PasswordField(password) {
            loginViewModel.onSigninChanged(
                email = email,
                password = it,
                passwordConfirm = passwordConfirm,
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        PasswordField(passwordConfirm) {
            loginViewModel.onSigninChanged(email = email, password = password, passwordConfirm = it)
        }
        Spacer(modifier = Modifier.size(16.dp))
        SignInButton(stringResource(id = R.string.signin_button), isSigninEnable) {
            loginViewModel.signInUser()
        }
    }
}
