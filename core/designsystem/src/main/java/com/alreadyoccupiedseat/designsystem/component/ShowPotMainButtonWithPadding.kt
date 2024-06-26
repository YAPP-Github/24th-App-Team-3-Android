package com.alreadyoccupiedseat.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H2

@Composable
fun ShowPotMainButtonWithPadding(
    text: String,
    enabled: Boolean = true,
    onClicked: () -> Unit,
) {
    Button(
        enabled = enabled,
        modifier = Modifier
            .background(ShowpotColor.Gray700)
            .padding(
                top = 4.dp,
                bottom = 54.dp
            )
            .fillMaxWidth()
            .height(55.dp)
            .background(ShowpotColor.MainRed),
        colors = ButtonColors(
            containerColor = ShowpotColor.MainRed,
            contentColor = Color.Black,
            disabledContainerColor = Color(0xFF202026),
            disabledContentColor = ShowpotColor.Gray400,
        ),
        shape = RectangleShape,
        onClick = onClicked,
    ) {
        ShowPotKoreanText_H2(
            text = text,
            color = if (enabled) Color.Black else ShowpotColor.Gray400,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}