package com.alreadyoccupiedseat.mypage

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alreadyoccupiedseat.designsystem.R
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.component.ShowPotTopBar
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H1

@Composable
fun MyPageTopBar(
    modifier: Modifier = Modifier,
    onSettingClicked: () -> Unit,
) {
    ShowPotTopBar(
        title = {
            ShowPotKoreanText_H1(
                text = stringResource(id = R.string.my_page),
                color = ShowpotColor.Gray300,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .padding(vertical = 7.dp)
            )
        },
        endIcon = {
            IconButton(onClick = {
                onSettingClicked()
            }) {
                Icon(
                    tint = ShowpotColor.Gray400,
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .padding(end = 12.dp),
                    painter = painterResource(id = R.drawable.ic_setting_36),
                    contentDescription = "Setting"
                )
            }

        },
        contentColor = ShowpotColor.Gray700,
    )
}