package com.alreadyoccupiedseat.designsystem.typo.korean

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.alreadyoccupiedseat.designsystem.ShowPotTypography
import com.alreadyoccupiedseat.designsystem.typo.ShowPotBaseText

@Composable
fun ShowPotKoreanText_B3_Regular(
    text: String,
    color: Color = Color.Black,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
) {
    ShowPotBaseText(
        text = text,
        style = ShowPotTypography.Korean.B3_regular.copy(color = color),
        maxLines = maxLines,
        overflow = overflow
    )
}