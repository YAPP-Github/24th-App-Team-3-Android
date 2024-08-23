package com.alreadyoccupiedseat.model.login

data class LoginResponse(
    val accessToken: String,
    val refreshToken: String
)