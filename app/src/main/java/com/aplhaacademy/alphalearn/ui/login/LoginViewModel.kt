package com.aplhaacademy.alphalearn.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aplhaacademy.alphalearn.pref.UserModel
import com.aplhaacademy.alphalearn.repository.UserRepository
import com.aplhaacademy.alphalearn.response.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: UserRepository) : ViewModel() {
    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }

    fun login(loginRequest: LoginRequest) =
        repository.login(loginRequest)
}