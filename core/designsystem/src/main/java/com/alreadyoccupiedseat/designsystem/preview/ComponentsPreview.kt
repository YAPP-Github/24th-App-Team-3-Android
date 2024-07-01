package com.alreadyoccupiedseat.designsystem.preview

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alreadyoccupiedseat.designsystem.component.ShowPotMainButton
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H0
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H1

@Composable
fun ComponentsPreview() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            ShowPotKoreanText_H0(text = "버튼들")
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            ShowPotKoreanText_H1(text = "CTA 버튼")
            Spacer(modifier = Modifier.height(12.dp))
        }

        item {
            ShowPotMainButton(
                text = "enabled Main Button",
                enabled = true,
                onClicked = {}
            )
            Spacer(modifier = Modifier.height(18.dp))
        }

        item {
            ShowPotMainButton(
                text = "disabled Main Button",
                enabled = false,
                onClicked = {}
            )
            Spacer(modifier = Modifier.height(18.dp))
        }
        item {
            ShowPotMainButton(
                modifier = Modifier.padding(
                    top = 4.dp,
                    bottom = 54.dp
                ),
                text = "enabled Main Button",
                enabled = true,
                onClicked = {})
        }
        item {
            ShowPotMainButton(
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                        bottom = 54.dp
                    ),
                text = "disabled Main Button With Padding",
                enabled = false,
                onClicked = {})
        }
    }
}
