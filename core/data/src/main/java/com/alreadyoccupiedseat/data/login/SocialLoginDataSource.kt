package com.alreadyoccupiedseat.data.login

import android.content.Context

interface SocialLoginDataSource {

    suspend fun login(activityContext: Context): String

}