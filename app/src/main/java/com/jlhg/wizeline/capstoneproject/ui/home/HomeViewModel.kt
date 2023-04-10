package com.jlhg.wizeline.capstoneproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlhg.wizeline.capstoneproject.domain.usecases.GetMoviesUseCase
import com.jlhg.wizeline.capstoneproject.domain.model.MovieItem
import com.jlhg.wizeline.capstoneproject.domain.usecases.LogoutUseCase
import com.jlhg.wizeline.capstoneproject.ui.common.ApiStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMoviesUseCase: GetMoviesUseCase, private val logoutUseCase: LogoutUseCase) : ViewModel() {

    private var page = 1

    private var _moviesList = MutableLiveData<List<MovieItem>>()
    val moviesList: LiveData<List<MovieItem>> get() = _moviesList

    private var _status = MutableLiveData<ApiStatus>()
    val status: LiveData<ApiStatus> get() = _status

    private val _goToLogin = MutableLiveData(false)
    val goToLogin: LiveData<Boolean> get() = _goToLogin

    fun nextPage(): Int{
        return page++
    }

    fun getTopRatedMovies() {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                if (page == 1) {
                    _moviesList.postValue(getMoviesUseCase.getTopRatedMovies(page))
                } else {
                    _moviesList.postValue(getMoviesUseCase.getTopRatedMovies(page))
                }
                _status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun getPopularMovies() {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                if (page == 1) {
                    _moviesList.postValue(getMoviesUseCase.getNowPlayingMovies(page))
                } else {
                    _moviesList.postValue(getMoviesUseCase.getNowPlayingMovies(page))
                }
                _status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun getLastestMovies() {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                if (page == 1) {
                    _moviesList.postValue(getMoviesUseCase.getLastestMovies(page))
                } else {
                    _moviesList.postValue(getMoviesUseCase.getLastestMovies(page))
                }
                _status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _status.value = ApiStatus.ERROR
            }
        }
    }

    fun logoutUser(){
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            logoutUseCase.invoke()
            _status.value = ApiStatus.SUCCESS
            _goToLogin.postValue(true)
        }
    }
}