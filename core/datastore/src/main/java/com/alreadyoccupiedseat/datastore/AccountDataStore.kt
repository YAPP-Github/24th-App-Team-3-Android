package com.alreadyoccupiedseat.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.accountDataStore: DataStore<Preferences> by preferencesDataStore(name = "account")

class AccountDataStore @Inject constructor(@ApplicationContext private val context: Context) {
    private val accessTokenKey = stringPreferencesKey("accessToken")
    private val refreshTokenKey = stringPreferencesKey("refreshToken")
    private val fcmTokenKey = stringPreferencesKey("fcmToken")


    suspend fun getAccessToken() = context.accountDataStore.data
        .map { preferences ->
            preferences[accessTokenKey]
        }.first()

    suspend fun updateAccessToken(accessToken: String) {
        context.accountDataStore.edit { preferences ->
            preferences[accessTokenKey] = accessToken
        }
    }

    suspend fun getRefreshToken() = context.accountDataStore.data
        .map { preferences ->
            preferences[refreshTokenKey]
        }.first()

    suspend fun updateRefreshToken(refreshToken: String) {
        context.accountDataStore.edit { preferences ->
            preferences[refreshTokenKey] = refreshToken
        }
    }

    suspend fun getFcmToken() = context.accountDataStore.data
        .map { preferences ->
            preferences[fcmTokenKey]
        }.first()

    suspend fun updateFcmToken(fcmToken: String) {
        context.accountDataStore.edit { preferences ->
            preferences[fcmTokenKey] = fcmToken
        }
    }
}