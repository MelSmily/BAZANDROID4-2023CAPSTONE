package com.jlhg.wizeline.capstoneproject.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlhg.wizeline.capstoneproject.domain.model.MovieDetail
import com.jlhg.wizeline.capstoneproject.domain.usecases.db.GetMovieDetailsFromDBUseCase
import com.jlhg.wizeline.capstoneproject.domain.usecases.db.InsertMovieDetailsToDBUseCase
import com.jlhg.wizeline.capstoneproject.domain.usecases.network.GetDetailsUseCase
import com.jlhg.wizeline.capstoneproject.ui.common.ApiStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getDetailsUseCase: GetDetailsUseCase,
    private val insertMovieDetailsToDBUseCase: InsertMovieDetailsToDBUseCase,
    private val getMovieDetailsFromDBUseCase: GetMovieDetailsFromDBUseCase
) : ViewModel() {

    private var _movieDetails = MutableStateFlow(MovieDetail())
    private var _status = MutableStateFlow(ApiStatus.LOADING)

    val movieDetails: StateFlow<MovieDetail> get() = _movieDetails
    val status: StateFlow<ApiStatus> get() = _status

    fun getAllDetails(id: Int) {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                val movieDetail = getDetailsUseCase.getDetails(id)!!
                _movieDetails.value = movieDetail
                insertMovieDetailsToDBUseCase.insertMovieDetails(movieDetail)
                _status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                val movieDetail = getMovieDetailsFromDBUseCase.getMovieDetails(id)
                if (movieDetail != null) {
                    _movieDetails.value = movieDetail
                    _status.value = ApiStatus.SUCCESS
                }else {
                    _status.value = ApiStatus.ERROR
                }
            }

        }

    }
}