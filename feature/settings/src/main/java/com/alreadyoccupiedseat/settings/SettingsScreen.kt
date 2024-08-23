package com.alreadyoccupiedseat.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.component.IconMenuWithCount
import com.alreadyoccupiedseat.designsystem.component.IconMenuWithText
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H1

@Composable
fun SettingsScreen(
    navController: NavController
) {


    SettingsScreenContent(
        onBackClicked = {
            navController.popBackStack()
        }
    )
}

@Composable
fun SettingsScreenContent(
    onBackClicked: () -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(6.dp))

                Icon(
                    painter = painterResource(id = com.alreadyoccupiedseat.designsystem.R.drawable.ic_arrow_36_left),
                    contentDescription = "back",
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        onBackClicked()
                    }
                )

                ShowPotKoreanText_H1(
                    text = "설정",
                    color = ShowpotColor.Gray300,
                )
            }
        },
        containerColor = ShowpotColor.Gray700
    ) { innerPadding ->

        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(innerPadding)
        ) {

            Spacer(modifier = Modifier.height(12.dp))

            IconMenuWithText(
                firstIcon = painterResource(id = com.alreadyoccupiedseat.designsystem.R.drawable.ic_info_24),
                title = "버전 0.0.1",
                text = "최신 버전입니다",
                onClicked = {}
            )

            Spacer(modifier = Modifier.height(8.dp))

            IconMenuWithCount(
                firstIcon = painterResource(id = com.alreadyoccupiedseat.designsystem.R.drawable.ic_profile_24),
                title = "계정",
                onClicked = {}
            )

            Spacer(modifier = Modifier.height(8.dp))

            IconMenuWithCount(
                firstIcon = painterResource(id = com.alreadyoccupiedseat.designsystem.R.drawable.ic_alarm_24_default),
                title = "알림 설정",
                onClicked = {}
            )

            Spacer(modifier = Modifier.height(8.dp))

            IconMenuWithCount(
                firstIcon = painterResource(id = com.alreadyoccupiedseat.designsystem.R.drawable.ic_privacy_24),
                title = "개인정보 처리 방침",
                onClicked = {}
            )

            Spacer(modifier = Modifier.height(8.dp))

            IconMenuWithCount(
                firstIcon = painterResource(id = com.alreadyoccupiedseat.designsystem.R.drawable.ic_report_24),
                title = "이용 약관",
                onClicked = {}
            )

            Spacer(modifier = Modifier.height(8.dp))

            IconMenuWithCount(
                firstIcon = painterResource(id = com.alreadyoccupiedseat.designsystem.R.drawable.ic_faq_24),
                title = "카카오 문의하기",
                onClicked = {}
            )

        }

    }
}