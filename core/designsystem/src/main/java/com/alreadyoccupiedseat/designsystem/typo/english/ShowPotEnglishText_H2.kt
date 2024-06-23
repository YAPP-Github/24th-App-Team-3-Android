package com.alreadyoccupiedseat.designsystem.typo.english

import androidx.compose.runtime.Composable
import com.alreadyoccupiedseat.designsystem.ShowPotTypography
import com.alreadyoccupiedseat.designsystem.typo.ShowPotBaseText

@Composable
fun ShowPotEnglishText_H2(
    text: String,
) {
    ShowPotBaseText(text = text, style = ShowPotTypography.English.H2)
}