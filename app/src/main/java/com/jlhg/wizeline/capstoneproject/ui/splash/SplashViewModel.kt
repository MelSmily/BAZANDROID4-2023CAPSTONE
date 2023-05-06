package com.jlhg.wizeline.capstoneproject.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlhg.wizeline.capstoneproject.domain.usecases.network.GetUserLoggedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val getUserLoggedUseCase: GetUserLoggedUseCase) : ViewModel() {
    private val _goToHome = MutableLiveData(false)
    private val _goToLogin = MutableLiveData(false)

    val goToHome: LiveData<Boolean> get() = _goToHome
    val goToLogin: LiveData<Boolean> get() = _goToLogin

    init {
        getLoggedUser()
    }

    private fun getLoggedUser() {
        viewModelScope.launch {
            delay(2000)
            if (getUserLoggedUseCase.invoke()) {
                _goToHome.postValue(true)
            } else {
                _goToLogin.postValue(true)
            }
        }
    }
}
