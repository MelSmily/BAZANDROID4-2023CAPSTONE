package com.jlhg.wizeline.capstoneproject.ui.component

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.jlhg.wizeline.capstoneproject.R

@Composable
fun ErrorDialog(title: String, text: String, onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = stringResource(R.string.login_error_dialog_positive_action),
                )
            }
        },
        title = { Text(title) },
        text = { Text(text) },
    )
}
