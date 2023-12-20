package com.aplhaacademy.alphalearn.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.aplhaacademy.alphalearn.pref.UserModel
import com.aplhaacademy.alphalearn.pref.UserPreference
import com.aplhaacademy.alphalearn.response.ApiService
import com.aplhaacademy.alphalearn.response.LoginRequest
import com.aplhaacademy.alphalearn.response.LoginResponse
import com.aplhaacademy.alphalearn.response.RegisterResponse
import com.aplhaacademy.alphalearn.response.Test
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val userPreference: UserPreference,
    private val apiService: ApiService,
) {
    suspend fun saveSession(user: UserModel) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    fun register(test: Test): LiveData<Result<RegisterResponse>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.register(test)
            emit(Result.Success(response))
        }catch (e: Exception){
            Log.d("Register", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    fun login(loginRequest: LoginRequest): LiveData<Result<LoginResponse>> = liveData {
        emit(Result.Loading)
        try {
            val response = apiService.login(loginRequest)
            if (response.token.isNotBlank()){
                val userModel = UserModel(loginRequest.email, response.token, true)
                saveSession(userModel)
                emit(Result.Success(response))
            }else{
                emit(Result.Error("Token is empty"))
            }
        }catch (e: Exception){
            Log.d("Login", e.message.toString())
            emit(Result.Error(e.message.toString()))
        }
    }

    companion object {
        @Volatile
        private var instance: UserRepository? = null
        fun getInstance(
            userPreference: UserPreference,
            apiService: ApiService
        ): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(userPreference, apiService)
            }.also { instance = it }
    }
}