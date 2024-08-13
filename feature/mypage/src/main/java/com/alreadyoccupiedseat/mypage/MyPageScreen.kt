package com.alreadyoccupiedseat.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alreadyoccupiedseat.designsystem.R
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.component.IconMenuWithCount
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H0
import com.alreadyoccupiedseat.designsystem.typo.korean.clickable.ShowPotKoreanText_H0_Clickable

@Composable
fun MyPageScreen(
    onLoginClicked: () -> Unit,
    onSettingClicked: () -> Unit,
    onFavoriteShowClicked: () -> Unit,
    onFinishedShowClicked: () -> Unit,
) {
    var isLogin by remember { mutableStateOf(false) }
    MyPageScreenContent(
        isLogin = isLogin,
        onLoginClicked = {
            isLogin = true
        },
        onSettingClicked = {
            // TODO 설정 화면으로 이동
        },
        onFavoriteShowClicked = {
            // TODO 관심 공연 화면으로 이동
        },
        onCloseShowClicked = {
            // TODO 티켓팅 종료 공연 화면으로 이동
        }
    )
}

@Composable
fun MyPageScreenContent(
    modifier: Modifier = Modifier,
    isLogin: Boolean,
    onLoginClicked: () -> Unit,
    onSettingClicked: () -> Unit,
    onFavoriteShowClicked: () -> Unit,
    onCloseShowClicked: () -> Unit,
) {
    Scaffold(
        containerColor = ShowpotColor.Gray700,
        topBar = {
            MyPageTopBar()
        },
        content = {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.Start,
                modifier = modifier
                    .padding(top = 12.dp)
                    .padding(it),
            ) {

                item {
                    WelcomeMessage(
                        isLogin = isLogin,
                        onActionMoveLogin = onLoginClicked
                    )
                }

                item {
                    Spacer(modifier = Modifier.height((-4).dp))
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp).background(ShowpotColor.Gray600)
                    )
                }

                item {
                    IconMenuWithCount(
                        firstIcon = painterResource(id = R.drawable.ic_heart_24),
                        title = stringResource(R.string.favorite_shows),
                        count = 0
                    ) {
                        onFavoriteShowClicked()
                    }
                }

                item {
                    IconMenuWithCount(
                        firstIcon = painterResource(id = R.drawable.ic_ticket_close),
                        title = stringResource(R.string.close_ticketing_shows),
                        count = 0
                    ) {
                        onCloseShowClicked()
                    }
                }

            }
        }
    )
}

@Composable
fun WelcomeMessage(isLogin: Boolean, onActionMoveLogin: () -> Unit) {

    Spacer(modifier = Modifier.height(25.dp))

    if (isLogin) {
        val nickName = "춤추는 현수"
        ShowPotKoreanText_H0(
            modifier = Modifier.padding(start = 16.dp),
            text = String.format(
                stringResource(R.string.test_of_my_page2),
                nickName
            ),
            color = ShowpotColor.White
        )
    } else {
        val startText = "로그인"
        ShowPotKoreanText_H0_Clickable(
            modifier = Modifier.padding(start = 16.dp),
            text = String.format(
                stringResource(R.string.test_of_my_page1),
                startText,
            ),
            color = ShowpotColor.Gray100,
            clickablePart = startText,
            onClick = {
                onActionMoveLogin()
            }
        )
    }

    Spacer(modifier = Modifier.height(16.dp))

}



