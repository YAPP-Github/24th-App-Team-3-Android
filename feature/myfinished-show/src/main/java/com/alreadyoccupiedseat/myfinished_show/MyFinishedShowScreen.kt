package com.alreadyoccupiedseat.myfinished_show

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alreadyoccupiedseat.designsystem.R
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.component.DefaultScreenWhenEmpty
import com.alreadyoccupiedseat.designsystem.component.ShowInfo
import com.alreadyoccupiedseat.designsystem.component.button.ShowPotSubButton

@Composable
fun MyFinishedShowScreen(navController: NavController) {
    MyFinishedShowScreenContent(
        onBackClicked = {
            navController.popBackStack()
        }
    )
}

@Composable
fun MyFinishedShowScreenContent(modifier: Modifier = Modifier, onBackClicked: () -> Unit) {
    val viewModel = hiltViewModel<MyFinishedViewModel>()
    Scaffold(
        containerColor = ShowpotColor.Gray700,
        topBar = {
            MyFinishedTopBar {
                onBackClicked()
            }
        },
        content = {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .padding(top = 12.dp)
                    .padding(it),
            ) {
                if (viewModel.showList.value.isEmpty()) {
                    item {
                        MyFinishedDataEmpty()
                    }
                } else {
                    itemsIndexed(viewModel.showList.value) { index, show ->
                        ShowInfo(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                                .clickable {
                                    // TODO 공연 상세 페이지 이동
                                },
                            imageUrl = show.posterImageURL,
                            showTitle = show.name,
                            dateInfo = "2024.12.$index (수) 오후 $index 시",
                            locationInfo = "KBS 아레나홀"
                        )
                    }
                }
            }
        }
    )
}

@Composable
fun MyFinishedDataEmpty(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 72.dp)
            .fillMaxSize()
    ) {

        DefaultScreenWhenEmpty(
            imageResId = R.drawable.img_empty_alarm,
            text = stringResource(id = R.string.no_alarm_show)
        )

        Spacer(modifier = Modifier.height(96.dp))

        ShowPotSubButton(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(id = R.string.action_show_info),
            onClicked = {
                // TODO 공연 찾기 페이지 이동
            }
        )
    }
}