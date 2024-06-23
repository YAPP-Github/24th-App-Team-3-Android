package com.alreadyoccupiedseat.designsystem.typo.korean

import androidx.compose.runtime.Composable
import com.alreadyoccupiedseat.designsystem.ShowPotTypography
import com.alreadyoccupiedseat.designsystem.typo.ShowPotBaseText

@Composable
fun ShowPotKoreanText_H2(
    text: String,
) {
    ShowPotBaseText(text = text, style = ShowPotTypography.Korean.H2)
}