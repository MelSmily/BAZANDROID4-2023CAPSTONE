package com.jlhg.wizeline.capstoneproject.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.jlhg.wizeline.capstoneproject.domain.model.MovieItem

@Composable
fun MovieListItem(movieItem: MovieItem, onClick: (Int) -> Unit) {
    Column {
        Box(
            modifier = Modifier
                .height(300.dp)
                .padding(4.dp)
                .clickable(
                    onClick = {onClick.invoke(movieItem.id)}
                )
        ) {
            AsyncImage(
                model = movieItem.posterPath,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}