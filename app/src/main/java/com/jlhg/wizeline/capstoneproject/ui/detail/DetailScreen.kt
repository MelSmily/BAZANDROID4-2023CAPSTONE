package com.jlhg.wizeline.capstoneproject.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.BookmarkAdd
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.jlhg.wizeline.capstoneproject.R
import com.jlhg.wizeline.capstoneproject.remote.model.Gender
import com.jlhg.wizeline.capstoneproject.domain.model.MovieDetail
import com.jlhg.wizeline.capstoneproject.ui.common.ApiStatus
import com.jlhg.wizeline.capstoneproject.ui.component.ErrorAnimation
import com.jlhg.wizeline.capstoneproject.ui.component.Loader
import kotlin.time.Duration.Companion.minutes

@Composable
fun DetailScreen(
    viewModel: DetailsViewModel,
    id: Int
) {
    LaunchedEffect(Unit) {
        viewModel.getAllDetails(id)
    }
    val status by viewModel.status.collectAsState()
    val movieDetails by viewModel.movieDetails.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
    ) {
        when (status) {
            ApiStatus.SUCCESS -> {
                MovieDetailBody(movie = movieDetails)
            }
            ApiStatus.LOADING -> {
                Loader()
            }
            ApiStatus.ERROR -> {
                ErrorAnimation()
            }
        }
    }
}

@Composable
private fun MovieDetailBody(movie: MovieDetail) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
            .verticalScroll(rememberScrollState())
            .navigationBarsPadding()
            .padding(horizontal = 8.dp, vertical = 12.dp)
    ) {
        val genres = remember {
            mutableStateOf(movie.genres)
        }

        val (backdrop, poster, originalTitle) = createRefs()
        val (rateScore, genresFlowRow, row, description) = createRefs()

        AsyncImage(
            model = movie.backdropPath,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                .constrainAs(backdrop) {},
            contentScale = ContentScale.FillHeight
        )

        AsyncImage(
            model = movie.posterPath,
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(180.dp)
                .clip(RoundedCornerShape(24.dp))
                .constrainAs(poster) {
                    centerAround(backdrop.bottom)
                    linkTo(start = parent.start, end = parent.end)
                }
        )
        Text(
            text = movie.originalTitle,
            modifier = Modifier.constrainAs(originalTitle) {
                linkTo(start = parent.start, end = parent.end)
                top.linkTo(poster.bottom, margin = 4.dp)
            },
            color = MaterialTheme.colors.primary
        )
        Row(
            modifier = Modifier.constrainAs(rateScore) {
                top.linkTo(originalTitle.bottom, margin = 4.dp)
                linkTo(start = parent.start, end = parent.end)
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.StarRate, contentDescription = "",
                tint = MaterialTheme.colors.primary
            )
            Text(text = stringResource(R.string.details_txt_rate, movie.voteAverage), color = MaterialTheme.colors.secondaryVariant)
        }

        MovieGenres(
            genres = genres.value,
            modifier = Modifier.constrainAs(genresFlowRow) {
                linkTo(start = parent.start, end = parent.end)
                top.linkTo(rateScore.bottom, margin = 4.dp)
            }
        )
        Row(
            modifier = Modifier
                .constrainAs(row) {
                    top.linkTo(genresFlowRow.bottom, margin = 8.dp)
                }
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = stringResource(R.string.detail_txt_duration), color = MaterialTheme.colors.secondaryVariant, fontSize = 16.sp)
                Text(text = "${movie.runtime.minutes}", color = MaterialTheme.colors.primary)
            }
            Column {
                Text(text = stringResource(R.string.details_txt_lenguage), color = MaterialTheme.colors.secondaryVariant, fontSize = 16.sp)
                Text(text = movie.spokenLanguages[0].englishName, color = MaterialTheme.colors.primary)
            }
            Column {
                Text(text = stringResource(R.string.details_txt_status), color = MaterialTheme.colors.secondaryVariant, fontSize = 16.sp)
                Text(text = movie.status, color = MaterialTheme.colors.primary)
            }

        }
        MovieDescription(
            description = movie.overview,
            modifier = Modifier.constrainAs(description) {
                top.linkTo(row.bottom, margin = 8.dp)
                linkTo(start = parent.start, end = parent.end)
            }
        )
    }
}

@Composable
private fun MovieGenres(
    modifier: Modifier = Modifier,
    genres: List<Gender>
) {
    LazyRow(
        modifier = modifier
    ) {
        items(genres){genre ->
            TextButton(
                onClick = {},
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.background,
                    contentColor = MaterialTheme.colors.primary
                ), modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
            ) {
                Text(text = genre.name, fontSize = 12.sp)
            }
        }
    }
}

@Composable
private fun MovieDescription(
    description: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.details_txt_description), color = MaterialTheme.colors.secondaryVariant,
            modifier = Modifier
                .padding(start = 16.dp, top = 12.dp),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h6,
        )
        Text(
            text = description,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            color = MaterialTheme.colors.primary, style = MaterialTheme.typography.body2
        )
    }
}