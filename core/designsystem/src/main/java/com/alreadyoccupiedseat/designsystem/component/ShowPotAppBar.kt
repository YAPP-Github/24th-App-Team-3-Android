package com.alreadyoccupiedseat.designsystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShowPotTopBar(
    title: @Composable () -> Unit = {},
    navigationIcon: @Composable (() -> Unit) = {},
    endIcon: @Composable (() -> Unit) = {},
    backgroundColor: Color = Color.Transparent,
    contentColor: Color = contentColorFor(backgroundColor),
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            Modifier
                .fillMaxWidth()
        ) {
            Row(
                Modifier
                    .padding(0.dp)
                    .height(44.dp)
                    .align(Alignment.CenterStart),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                navigationIcon()
                title()
            }
            Box(
                Modifier.align(Alignment.CenterEnd)  // Positioning the end icon
            ) {
                endIcon()  // Displaying the end icon
            }
        }
    }
}
