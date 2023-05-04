package com.jlhg.wizeline.capstoneproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlhg.wizeline.capstoneproject.domain.model.MovieItem
import com.jlhg.wizeline.capstoneproject.domain.usecases.db.GetMoviesFromDBUseCase
import com.jlhg.wizeline.capstoneproject.domain.usecases.db.InsertMoviesToDBUseCase
import com.jlhg.wizeline.capstoneproject.domain.usecases.network.GetMoviesUseCase
import com.jlhg.wizeline.capstoneproject.domain.usecases.network.LogoutUseCase
import com.jlhg.wizeline.capstoneproject.ui.common.ApiStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val logoutUseCase: LogoutUseCase,
    private val insertMoviesToDBUseCase: InsertMoviesToDBUseCase,
    private val getMoviesFromDBUseCase: GetMoviesFromDBUseCase
) : ViewModel() {

    private var page = 1

    private var _status = MutableLiveData<ApiStatus>()
    private var _moviesList = MutableLiveData<List<MovieItem>>()
    private val _goToLogin = MutableLiveData(false)

    val status: LiveData<ApiStatus> get() = _status
    val moviesList: LiveData<List<MovieItem>> get() = _moviesList
    val goToLogin: LiveData<Boolean> get() = _goToLogin

    fun nextPage(): Int {
        return page++
    }

    fun getNowPlayingMovies() {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                val movies = getMoviesUseCase.getNowPlayingMovies(page)
                _moviesList.postValue(movies)
                insertMoviesToDBUseCase.insertNowPlayingMovies(movies)
                _status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                val movies = getMoviesFromDBUseCase.getNowPlayingMovies()
                _moviesList.postValue(movies)
                _status.value = if (movies.isEmpty()) ApiStatus.ERROR else ApiStatus.SUCCESS
            }
        }
    }

    fun getTopRatedMovies() {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                val movies = getMoviesUseCase.getTopRatedMovies(page)
                _moviesList.postValue(movies)
                insertMoviesToDBUseCase.insertTopRatedMovies(movies)
                _status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                val movies = getMoviesFromDBUseCase.getTopRatedMovies()
                _moviesList.postValue(movies)
                _status.value = if (movies.isEmpty()) ApiStatus.ERROR else ApiStatus.SUCCESS
            }
        }
    }

    fun getLastestMovies() {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            try {
                val movies = getMoviesUseCase.getLastestMovies(page)
                _moviesList.postValue(movies)
                insertMoviesToDBUseCase.insertLastestMovies(movies)
                _status.value = ApiStatus.SUCCESS
            } catch (e: Exception) {
                val movies = getMoviesFromDBUseCase.getLastestMovies()
                _moviesList.postValue(movies)
                _status.value = if (movies.isEmpty()) ApiStatus.ERROR else ApiStatus.SUCCESS
            }
        }
    }

    fun logoutUser() {
        _status.value = ApiStatus.LOADING
        viewModelScope.launch {
            logoutUseCase.invoke()
            _status.value = ApiStatus.SUCCESS
            _goToLogin.postValue(true)
        }
    }
}
