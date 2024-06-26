package com.alreadyoccupiedseat.designsystem.typo.korean

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.alreadyoccupiedseat.designsystem.ShowPotTypography
import com.alreadyoccupiedseat.designsystem.typo.ShowPotBaseText

@Composable
fun ShowPotKoreanText_B3_Regular(
    text: String,
    color: Color = Color.Black,
) {
    ShowPotBaseText(text = text, style = ShowPotTypography.Korean.B3_regular.copy(
        color = color
    ))
}