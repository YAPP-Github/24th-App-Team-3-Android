package com.alreadyoccupiedseat.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.alreadyoccupiedseat.designsystem.R
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.component.IconMenuWithCount
import com.alreadyoccupiedseat.designsystem.component.ShowInfo
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H0
import com.alreadyoccupiedseat.designsystem.typo.korean.clickable.ShowPotKoreanText_H0_Clickable

@Composable
fun MyPageScreen(
    onLoginClicked: () -> Unit,
    onSettingClicked: () -> Unit,
    onFavoriteShowClicked: () -> Unit,
    onFinishedShowClicked: () -> Unit,
) {
    // TODO 로그인 상태에 따라 isLogin 값 변경 (LaunchedEffect 사용 + 샘영주기)
    var isLogin by remember { mutableStateOf(false) }
    MyPageScreenContent(
        isLogin = isLogin,
        onLoginClicked = {
            isLogin = true
        },
        onSettingClicked = {

        },
        onFavoriteShowClicked = {

        },
        onCloseShowClicked = {

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
    val viewModel = hiltViewModel<MyPageViewModel>()
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
                        count = if (isLogin) 43 else 0
                    ) {
                        onCloseShowClicked()
                    }
                }

                item {
                    Spacer(modifier = Modifier.height(18.dp))
                }

                itemsIndexed(viewModel.showList.value) {index, show ->
                    if (isLogin) {
                        ShowInfo(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .clickable {
                                    // TODO 공연 상세 페이지 이동
                                },
                            imageUrl = show.posterImageURL,
                            showTitle = show.name,
                            dateInfo = "2024.12.$index (수) 오후 $index 시",
                            locationInfo = "KBS 아레나홀",
                        )
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
        val nickName = "엶시히 하는 현수"
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



