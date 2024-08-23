package com.alreadyoccupiedseat.login

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alreadyoccupiedseat.data.login.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface LoginScreenEvent {
    data object Idle : LoginScreenEvent
    data object LoginRequested : LoginScreenEvent
    data object LoginCompleted : LoginScreenEvent
    data class LoginError(val errorMessage: String) : LoginScreenEvent
}

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private var _event = MutableStateFlow<LoginScreenEvent>(LoginScreenEvent.Idle)
    val event = _event

    fun tryKakaoLogin(activityContext: Context) {
        viewModelScope.launch {
            _event.emit(LoginScreenEvent.LoginRequested)
            if (loginRepository.kakaoLogin(activityContext).isSuccess) {
                _event.emit(LoginScreenEvent.LoginCompleted)
            } else {
                _event.emit(LoginScreenEvent.LoginError("카카오 로그인 실패"))
            }
        }
    }

}