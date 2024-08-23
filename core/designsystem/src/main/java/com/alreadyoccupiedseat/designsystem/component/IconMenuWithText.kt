package com.alreadyoccupiedseat.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_B1_Regular
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H1

@Composable
fun IconMenuWithText(
    modifier: Modifier = Modifier,
    firstIcon: Painter,
    title: String,
    text: String,
    onClicked: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onClicked()
            }
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = firstIcon,
            contentDescription = "icon",
            tint = ShowpotColor.Gray300,
            modifier = Modifier.size(24.dp)
        )

        Spacer(Modifier.width(10.dp))

        ShowPotKoreanText_H1(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 4.dp),
            text = title,
            color = ShowpotColor.Gray100,
        )

        ShowPotKoreanText_B1_Regular(
            text = text,
            color = ShowpotColor.Gray200,
        )

    }
}