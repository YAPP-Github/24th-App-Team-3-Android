package com.alreadyoccupiedseat.designsystem.typo.english

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.alreadyoccupiedseat.designsystem.ShowPotTypography
import com.alreadyoccupiedseat.designsystem.typo.ShowPotBaseText

@Composable
fun ShowPotEnglishText_H4(
    text: String,
    color: Color = Color.Black,
) {
    ShowPotBaseText(text = text, style = ShowPotTypography.English.H4.copy(
        color = color
    ))
}