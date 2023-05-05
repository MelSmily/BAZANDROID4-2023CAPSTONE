package com.jlhg.wizeline.capstoneproject.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SignInButton(text: String, enable: Boolean, onClick: () -> Unit) {
    androidx.compose.material.Button(
        onClick = onClick,
        enabled = enable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            disabledBackgroundColor = MaterialTheme.colors.secondary,
            contentColor = Color.White,
            disabledContentColor = Color.White,
        ),
    ) {
        Text(text)
    }
}
