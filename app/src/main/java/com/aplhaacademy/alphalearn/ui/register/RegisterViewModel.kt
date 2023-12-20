package com.aplhaacademy.alphalearn.ui.register

import androidx.lifecycle.ViewModel
import com.aplhaacademy.alphalearn.repository.UserRepository
import com.aplhaacademy.alphalearn.response.Test

class RegisterViewModel(private val userRepository: UserRepository) : ViewModel() {
    fun register(test: Test) =
        userRepository.register(test)
}