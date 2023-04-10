package com.jlhg.wizeline.capstoneproject.ui.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.FullscreenExit
import androidx.compose.material.icons.outlined.TransitEnterexit
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jlhg.wizeline.capstoneproject.R

@Composable
fun TopBar(onClick: () -> Unit){
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        actions = {
            TopAppBarActionButton(
                onClick = onClick
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary,
        elevation = 8.dp
    )
}

@Composable
private fun TopAppBarActionButton(
    onClick: () -> Unit
) {
    IconButton(onClick = {
        onClick()
    }) {
        Icon(
            imageVector = Icons.Outlined.ExitToApp,
            contentDescription = "Logout",
            tint = MaterialTheme.colors.primary
        )
    }
}