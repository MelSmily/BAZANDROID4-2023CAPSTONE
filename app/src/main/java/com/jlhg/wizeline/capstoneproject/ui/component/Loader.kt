package com.jlhg.wizeline.capstoneproject.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.jlhg.wizeline.capstoneproject.R

@Composable
fun Loader() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.movie_loader),
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = true,
        speed = 1F,
        restartOnPlay = false,
    )
    Box(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary.copy(alpha = 0.2f))
            .clickable(onClick = {}),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            LottieAnimation(
                composition,
                progress,
                modifier = Modifier.size(200.dp),
            )
        }
    }
}
