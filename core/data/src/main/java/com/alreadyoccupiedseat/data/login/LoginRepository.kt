package com.alreadyoccupiedseat.data.login

import android.content.Context

interface LoginRepository {

    suspend fun kakaoLogin(activityContext: Context): Result<Unit>

    suspend fun googleLogin(): Result<Unit>

    suspend fun reIssueToken(): Result<Unit>

}