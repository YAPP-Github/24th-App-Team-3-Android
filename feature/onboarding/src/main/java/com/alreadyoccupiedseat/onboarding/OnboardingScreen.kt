package com.alreadyoccupiedseat.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alreadyoccupiedseat.core.extension.calculateCurrentOffsetForPage
import com.alreadyoccupiedseat.designsystem.R
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H0
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H2
import kotlinx.coroutines.flow.collectLatest
import kotlin.math.absoluteValue

@Composable
fun OnboardingScreen(
    onOnboardingCompleted: () -> Unit,
) {

    val viewModel = hiltViewModel<OnboardingViewModel>()
    LaunchedEffect(viewModel.event) {
        viewModel.event.collectLatest { event ->
            when (event) {
                OnboardingScreenEvent.OnboardingCompleted -> {
                    onOnboardingCompleted()
                }

                else -> {

                }
            }
        }
    }

    OnboardingContent(
        onOnboardingCompleted = { viewModel.completeOnboarding() }
    )

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingContent(
    onOnboardingCompleted: () -> Unit,
) {

    val pagerState = rememberPagerState(
        pageCount = { 2 }
    )

    var color by remember {
        mutableStateOf(ShowpotColor.MainOrange)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize()
                    .padding(paddingValues)
                    .background(color = color),
            ) {

                HorizontalPager(pagerState) { currentPage ->


                    val pageOffset =
                        pagerState.calculateCurrentOffsetForPage(currentPage).absoluteValue

                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .graphicsLayer {
                                color = lerp(
                                    ShowpotColor.MainOrange, ShowpotColor.MainGreen,
                                    if (currentPage == 0) pageOffset.coerceIn(0f, 1f)
                                    else 1f - pageOffset.coerceIn(0f, 1f)
                                )
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Image(
                            modifier = Modifier.padding(top = 85.dp)
                                .size(341.dp, 345.dp),
                            painter = painterResource(
                                id =
                                if (currentPage == 0) R.drawable.img_onboarding_alarm
                                else R.drawable.img_onboarding_genre
                            ),
                            contentDescription = "onboarding image"
                        )

                        ShowPotKoreanText_H0(
                            modifier = Modifier.padding(top = 56.dp),
                            text = if (currentPage == 0) "티켓팅 알림받기" else "장르/아티스트 구독하기"
                        )

                        ShowPotKoreanText_H2(
                            modifier = Modifier.padding(top = 8.dp),
                            text = if (currentPage == 0) "중요한 티켓팅, 잊어버리지 않게"
                            else "내가 관심 있는 장르/아티스트의"
                        )

                        ShowPotKoreanText_H2(
                            modifier = Modifier.padding(top = 4.dp),
                            text = if (currentPage == 0) "푸쉬 알림을 드릴게요!"
                            else "내한 소식을 빠르게 받아볼 수 있어요!"
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 40.dp),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .background(
                                    if (pagerState.currentPage == iteration) ShowpotColor.White else ShowpotColor.Gray500,
                                    CircleShape
                                )
                        )
                        if (iteration != pagerState.pageCount - 1) {
                            Spacer(modifier = Modifier.width(12.dp))
                        }
                    }
                }

                Box(
                    modifier = Modifier.fillMaxWidth()
                        .padding(top = 62.dp)
                        .padding(horizontal = 16.dp)
                        .height(55.dp)
                        .background(ShowpotColor.Gray700)
                        .clickable {
                            onOnboardingCompleted()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    ShowPotKoreanText_H2(
                        text = "쇼팟 시작하기",
                        color = ShowpotColor.White
                    )
                }
            }
        }
    )


}