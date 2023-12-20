package com.aplhaacademy.alphalearn.di

import android.content.Context
import com.aplhaacademy.alphalearn.pref.UserPreference
import com.aplhaacademy.alphalearn.pref.dataStore
import com.aplhaacademy.alphalearn.repository.UserRepository
import com.aplhaacademy.alphalearn.response.ApiConfig

object Injection {
    fun provideRepository(context: Context): UserRepository {
        val pref = UserPreference.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return UserRepository.getInstance(pref, apiService)
    }
}