package com.alreadyoccupiedseat.designsystem.typo.korean.clickable

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alreadyoccupiedseat.designsystem.ShowPotTypography
import com.alreadyoccupiedseat.designsystem.ShowpotColor

@Composable
fun ShowPotKoreanText_H0_Clickable(
    modifier: Modifier = Modifier,
    text: String,
    clickablePart: String,
    onClick: () -> Unit,
    color: Color = ShowpotColor.White,
    anotherColor: Color = ShowpotColor.White,
    textAlign: TextAlign = TextAlign.Unspecified,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = anotherColor, textDecoration = TextDecoration.Underline)) {
            append(clickablePart)
        }
        val nonClickablePart = text.replace(clickablePart, "")
        append(nonClickablePart)
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            val start = annotatedString.indexOf(clickablePart)
            val end = start + clickablePart.length
            if (offset in start until end) {
                onClick()
            }
        },
        modifier = modifier,
        style = ShowPotTypography.Korean.H0.copy(color = color, lineHeight = 36.sp),
        maxLines = maxLines,
        overflow = overflow
    )
}