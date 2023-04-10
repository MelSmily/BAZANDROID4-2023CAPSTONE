package com.jlhg.wizeline.capstoneproject.ui.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlhg.wizeline.capstoneproject.domain.usecases.GetDetailsUseCase
import com.jlhg.wizeline.capstoneproject.domain.model.MovieDetailsItem
import com.jlhg.wizeline.capstoneproject.ui.common.ApiStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getDetailsUseCase: GetDetailsUseCase
) : ViewModel() {

    private var _movieDetails = MutableLiveData<MovieDetailsItem>()
    private var _idMovie = MutableLiveData(1)

    val movieDetails: LiveData<MovieDetailsItem> get() = _movieDetails
    val idMovie: LiveData<Int> get() = _idMovie

    private var _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> get() = _status

    init {
        getAllDetails(idMovie.value!!)
    }

    private fun getAllDetails(id: Int) {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                _movieDetails.value = getDetailsUseCase.getDetails(id)
                _status.value = ApiStatus.SUCCESS
                Log.d("tag", "${movieDetails.value}")
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                Log.d("tag", "${e.message}")
            }

        }

    }
}