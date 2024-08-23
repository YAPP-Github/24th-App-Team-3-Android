package com.alreadyoccupiedseat.model.login

data class LoginRequest(
    val fcmToken: String,
    val identifier: String,
    val socialType: String
)