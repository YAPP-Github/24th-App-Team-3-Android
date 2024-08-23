package com.alreadyoccupiedseat.data.login.kakao

import android.content.Context
import com.alreadyoccupiedseat.core.extension.EMPTY
import com.alreadyoccupiedseat.data.login.KakaoLoginDataSource
import com.alreadyoccupiedseat.data.login.SocialLoginDataSource
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resumeWithException

@KakaoLoginDataSource
class KakaoLoginDataSourceImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : SocialLoginDataSource {
    @OptIn(ExperimentalCoroutinesApi::class)
    override suspend fun login(activityContext: Context): String {
        return suspendCancellableCoroutine { continuation ->
            // 카카오 로그인 콜백
            val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    continuation.resumeWithException(Exception(error.message))
                } else if (token != null) {
                    continuation.resume(token.idToken ?: String.EMPTY) {
                        // onCancellation
                    }
                } else {
                    continuation.resumeWithException(Exception("카카오 소셜 로그인 실패"))
                }
            }

            // 카카오 로그인 시작
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(activityContext)) {
                UserApiClient.instance.loginWithKakaoTalk(activityContext, callback = callback)
            } else {
                UserApiClient.instance.loginWithKakaoAccount(activityContext, callback = callback)
            }
        }
    }
}