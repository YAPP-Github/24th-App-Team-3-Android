package com.alreadyoccupiedseat.showpot

import android.os.Build
import android.Manifest
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun EssentialPermissionDialog(
    onPostNotificationPermissionGranted: (Boolean) -> Unit = {},
) {

    val postNotificationPermissionState = rememberPermissionState(
        Manifest.permission.POST_NOTIFICATIONS,
    ) { isGranted ->
        onPostNotificationPermissionGranted(isGranted)
    }

    // first request or forever denied case
    LaunchedEffect(postNotificationPermissionState) {
        if (postNotificationPermissionState.status.isGranted.not() && postNotificationPermissionState.status.shouldShowRationale.not()) {
            postNotificationPermissionState.launchPermissionRequest()
        }
    }

    // Show rationale Dialog For Notification Permission
    if (postNotificationPermissionState.status.isGranted.not() && postNotificationPermissionState.status.shouldShowRationale) {
        Toast.makeText(LocalContext.current, "2차로 권한을 요청할 다이어로그 화면!", Toast.LENGTH_SHORT)
            .show()
    }
}