package com.alreadyoccupiedseat.notification

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.component.IconMenuWithCount
import com.alreadyoccupiedseat.designsystem.component.ticketSlider.TicketSlidePager
import com.alreadyoccupiedseat.designsystem.typo.english.ShowPotEnglishText_H0
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H0
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H1

@Preview
@Composable
fun PreviewNotificationScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NotificationScreen(
        navController = navController,
        onMyAlarmSettingClicked = {}
    )
}

@Composable
fun NotificationScreen(
    navController: NavController,
    onMyAlarmSettingClicked: () -> Unit,
) {
    NotificationScreenContent(
        onMyAlarmSettingClicked = onMyAlarmSettingClicked,
    )
}

// Todo: Need To Real Data
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NotificationScreenContent(
    onMyAlarmSettingClicked: () -> Unit,
) {

    val pagerState = rememberPagerState(pageCount = { 5 })
    Scaffold(
        containerColor = ShowpotColor.Gray700,
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .padding(it)
        ) {

            item {
                Spacer(Modifier.height(6.dp))
            }

            item {
                ShowPotKoreanText_H1(
                    text = "티켓팅이 임박한 공연",
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                    color = ShowpotColor.Gray300
                )
            }

            item {
                Spacer(Modifier.height(1.dp))
            }

            item {
                ShowPotEnglishText_H0(
                    text = "Dua Lipa",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = ShowpotColor.Gray100
                )
            }

            item {
                Row {
                    ShowPotKoreanText_H0(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "공연 티켓팅까지, ",
                        color = ShowpotColor.Gray100,
                    )

                    ShowPotKoreanText_H0(
                        modifier = Modifier.padding(start = 8.dp),
                        text = "D-5",
                        color = ShowpotColor.MainOrange,
                    )
                }
            }

            item {
                TicketSlidePager(pagerState)
            }

            item {
                Spacer(Modifier.height(23.dp))
            }

            item {
                IconMenuWithCount(
                    firstIcon = painterResource(id = com.alreadyoccupiedseat.designsystem.R.drawable.ic_alarm_24_default),
                    title = "알림 설정한 공연",
                    count = 12,
                ) {
                    onMyAlarmSettingClicked()
                }
            }

            item {
                Spacer(Modifier.height(12.dp))
            }

            item {
                IconMenuWithCount(
                    firstIcon = painterResource(id = com.alreadyoccupiedseat.designsystem.R.drawable.ic_artist_24),
                    title = "구독한 아티스트",
                    count = 3,
                ) {

                }
            }

            item {
                Spacer(Modifier.height(12.dp))
            }

            item {
                IconMenuWithCount(
                    firstIcon = painterResource(id = com.alreadyoccupiedseat.designsystem.R.drawable.ic_genre_24),
                    title = "구독한 장르",
                    count = 5,
                ) {

                }
            }
        }

    }
}