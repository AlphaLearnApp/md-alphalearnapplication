package com.aplhaacademy.alphalearn.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("user")
	val user: User
)

data class User(

	@field:SerializedName("date")
	val date: String,

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("__v")
	val v: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("_id")
	val id: String,

	@field:SerializedName("email")
	val email: String
)

data class Test(

	val name: String,

	val email: String,

	val password: String,
)
