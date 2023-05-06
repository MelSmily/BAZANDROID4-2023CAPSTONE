package com.jlhg.wizeline.capstoneproject.ui.login

import android.annotation.SuppressLint
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jlhg.wizeline.capstoneproject.domain.usecases.network.CreateAccountUseCase
import com.jlhg.wizeline.capstoneproject.domain.usecases.network.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers.io
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val createAccountUseCase: CreateAccountUseCase,
) : ViewModel() {

    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _passwordConfirm = MutableLiveData<String>()
    private val _isLoginEnable = MutableLiveData(false)
    private val _isSigninEnable = MutableLiveData(false)
    private val _isLoading = MutableLiveData(false)
    private val _showErrorDialog = MutableLiveData(false)
    private val _goToHome = MutableLiveData(false)

    val email: LiveData<String> get() = _email
    val password: LiveData<String> get() = _password
    val passwordConfirm: LiveData<String> get() = _passwordConfirm
    val isLoginEnable: LiveData<Boolean> get() = _isLoginEnable
    val isSigninEnable: LiveData<Boolean> get() = _isSigninEnable
    val isLoading: LiveData<Boolean> get() = _isLoading
    val showErrorDialog: LiveData<Boolean> get() = _showErrorDialog
    val goToHome: LiveData<Boolean> get() = _goToHome

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
        _isLoginEnable.value = enableLogin(email, password)
    }

    fun onSigninChanged(email: String, password: String, passwordConfirm: String) {
        _email.value = email
        _password.value = password
        _passwordConfirm.value = passwordConfirm
        _isSigninEnable.value = enableSignin(email, password, passwordConfirm)
    }

    fun cleanData() {
        _email.value = ""
        _password.value = ""
        _passwordConfirm.value = ""
    }

    fun setShowErrorDialog(showErrorDialog: Boolean) {
        _showErrorDialog.postValue(showErrorDialog)
    }

    private fun enableLogin(email: String, password: String) =
        Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6

    private fun enableSignin(email: String, password: String, passwordConfirm: String) =
        Patterns.EMAIL_ADDRESS.matcher(email)
            .matches() && password.length > 6 && passwordConfirm == password

    @SuppressLint("CheckResult")
    fun loginUser() {
        _isLoading.value = true
        loginUseCase(email.value!!, password.value!!)
            .subscribeOn(io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _isLoading.postValue(false)
                _goToHome.postValue(true)
            }, {
                setShowErrorDialog(true)
            })
    }

    fun signInUser() {
        _isLoading.value = true
        viewModelScope.launch {
            _isLoading.postValue(false)
            if (createAccountUseCase(email.value!!, password.value!!)) {
                _goToHome.postValue(true)
            } else {
                setShowErrorDialog(true)
            }
        }
    }
}
