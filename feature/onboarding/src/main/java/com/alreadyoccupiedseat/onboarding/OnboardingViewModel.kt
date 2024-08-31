package com.alreadyoccupiedseat.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alreadyoccupiedseat.datastore.OnboardingDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface OnboardingScreenEvent {
    data object Idle : OnboardingScreenEvent
    data object OnboardingCompleted : OnboardingScreenEvent
}

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val onboardingDataStore: OnboardingDataStore
) : ViewModel() {

    init {
        viewModelScope.launch {
            val isOnboardingFinished = isOnboardingFinished()
            _event.emit(if (isOnboardingFinished) OnboardingScreenEvent.OnboardingCompleted else OnboardingScreenEvent.Idle)
        }
    }

    private var _event = MutableSharedFlow<OnboardingScreenEvent>()
    val event = _event

    fun completeOnboarding() {
        viewModelScope.launch {
            onboardingDataStore.updateWhetherOnboardingIsFinished(true)
            _event.emit(OnboardingScreenEvent.OnboardingCompleted)
        }
    }

    private suspend fun isOnboardingFinished() = onboardingDataStore.getWhetherIsFinished()

}
