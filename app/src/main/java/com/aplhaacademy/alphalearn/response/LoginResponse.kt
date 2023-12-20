package com.aplhaacademy.alphalearn.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

	@field:SerializedName("userId")
	val userId: String,

	@field:SerializedName("token")
	val token: String
)

data class LoginRequest(

	val email: String,

	val password: String,
)
