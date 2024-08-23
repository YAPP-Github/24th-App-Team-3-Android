package com.alreadyoccupiedseat.withdraw

import androidx.lifecycle.ViewModel
import com.alreadyoccupiedseat.core.extension.EMPTY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class WithDrawScreenState(
    val inputText: String = String.EMPTY,
)

@HiltViewModel
class WithDrawViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableStateFlow(WithDrawScreenState())
    val state: StateFlow<WithDrawScreenState> = _state

    fun updateInputText(newString: String) {
        _state.value = _state.value.copy(inputText = newString)
    }
}