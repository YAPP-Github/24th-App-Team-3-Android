package com.alreadyoccupiedseat.showpot

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.alreadyoccupiedseat.designsystem.ShowPotTheme
import com.alreadyoccupiedseat.login.LoginScreen
import com.alreadyoccupiedseat.onboarding.OnboardingScreen
import com.alreadyoccupiedseat.showpot.ui.AppScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, ShowPotFcmService::class.java))

        setContent {
            // TODO: Improve the reactivity
            // ex) do not let them see the onboarding screen "at all" if they have already completed it
            ShowPotTheme {

                EssentialPermissionDialog()

                val viewModel = hiltViewModel<MainActivityViewModel>()
                val state = viewModel.state.collectAsState()

                if (state.value.isOnboardingCompleted && state.value.isLoggedIn) {
                    AppScreen(state.value.isLoggedIn)
                } else if (!state.value.isLoggedIn) {
                    LoginScreen() {
                        viewModel.loginSuccess()
                    }
                } else {
                    OnboardingScreen {
                        viewModel.onboardingCompleted()
                    }
                }
            }
        }
    }
}