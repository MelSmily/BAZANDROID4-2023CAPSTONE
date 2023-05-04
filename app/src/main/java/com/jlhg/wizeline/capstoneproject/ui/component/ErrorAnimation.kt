package com.jlhg.wizeline.capstoneproject.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import com.jlhg.wizeline.capstoneproject.R

@Composable
fun ErrorAnimation() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.page_not_found)
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        speed = 1F,
        restartOnPlay = false
    )
    Box(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary.copy(alpha = 0.2f))
            .clickable(onClick = {}),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LottieAnimation(
                composition,
                progress,
                modifier = Modifier.size(200.dp)
            )
            Text(
                text = stringResource(id = R.string.error_animation_txt),
                fontSize = 12.sp,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center
            )
        }
    }
}
