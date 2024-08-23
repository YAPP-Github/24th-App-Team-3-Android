package com.alreadyoccupiedseat.data.login

import com.alreadyoccupiedseat.data.login.kakao.KakaoLoginDataSourceImpl
import com.alreadyoccupiedseat.data.login.remote.RemoteLoginDataSource
import com.alreadyoccupiedseat.data.login.remote.RemoteLoginDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginModule {

    @Singleton
    @Binds
    @KakaoLoginDataSource
    abstract fun bindKakaoLoginDataSource(kakaoLoginDataSourceImpl: KakaoLoginDataSourceImpl): SocialLoginDataSource


    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(remoteLoginDataSourceImpl: RemoteLoginDataSourceImpl): RemoteLoginDataSource

    @Singleton
    @Binds
    abstract fun bindLoginRepository(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository

}