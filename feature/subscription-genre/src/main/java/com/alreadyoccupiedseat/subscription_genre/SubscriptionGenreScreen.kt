package com.alreadyoccupiedseat.subscription_genre

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alreadyoccupiedseat.designsystem.R
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.component.ShowPotGenre
import com.alreadyoccupiedseat.designsystem.component.ShowPotMainButton
import com.alreadyoccupiedseat.designsystem.component.ShowPotTopBar
import com.alreadyoccupiedseat.designsystem.component.bottomSheet.SheetHandler
import com.alreadyoccupiedseat.designsystem.component.bottomSheet.ShowPotBottomSheet
import com.alreadyoccupiedseat.designsystem.component.snackbar.CheckIconSnackbar
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H1
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H2
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SubscriptionGenreScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {

    val viewModel = hiltViewModel<SubscriptionGenreViewModel>()
    val event = viewModel.event.collectAsState()

    when (event.value) {
        SubscriptionGenreScreenEvent.Idle -> {
            SubscriptionGenreScreenContent(
                modifier = modifier,
                viewModel = viewModel,
                onBackClicked = {
                    navController.popBackStack()
                },
                onSubscribeButtonClicked = {
                    viewModel.subscribeGenres()
                },
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionGenreScreenContent(
    modifier: Modifier = Modifier,
    viewModel: SubscriptionGenreViewModel,
    onBackClicked: () -> Unit,
    onSubscribeButtonClicked: () -> Unit = {},
) {
    val genreList by remember { mutableStateOf(viewModel.tempGenreList) }
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }

    var isSheetVisible by remember { mutableStateOf(false) }
    var isSubscribeButtonVisible by remember { mutableStateOf(false) }

    if (isSheetVisible) {
        SubscriptionBottomSheet(
            onDismissRequest = { isSheetVisible = false }
        )
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(
                hostState = snackBarHostState,
            ) { snackBarData ->
                CheckIconSnackbar(
                    mainText = snackBarData.visuals.message,
                    actionText = "보러가기",
                    onIconClicked = {
                        // onIconClicked()
                    },
                ) {
                    // onActionClicked()
                }
            }
        },
        topBar = {
            SubscriptionTopBar(onBackClicked = onBackClicked)
        },
        content = {
            SubscriptionGenreContent(
                modifier = modifier,
                innerPadding = it,
                genreList = genreList,
                isSubscribeButtonVisible = isSubscribeButtonVisible,
                onGenreClick = { isSelected ->
                    if (isSelected) {
                        isSheetVisible = true
                    }
                    isSubscribeButtonVisible = true
                },
                onSubscribeButtonClicked = onSubscribeButtonClicked,
                snackBarHostState = snackBarHostState,
                scope = scope
            )
        }
    )
}

@Composable
fun SubscriptionTopBar(onBackClicked: () -> Unit) {
    ShowPotTopBar(
        navigationIcon = {
            IconButton(onClick = onBackClicked) {
                Icon(
                    modifier = Modifier.padding(1.dp),
                    painter = painterResource(R.drawable.ic_arrow_36_left),
                    contentDescription = "Back"
                )
            }
        },
        title = {
            ShowPotKoreanText_H1(
                text = stringResource(id = R.string.subscribe_genre),
                color = ShowpotColor.Gray100,
                modifier = Modifier.padding(start = 4.dp)
            )
        },
        backgroundColor = ShowpotColor.Gray700,
        contentColor = ShowpotColor.White
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubscriptionBottomSheet(onDismissRequest: () -> Unit) {
    ShowPotBottomSheet(
        onDismissRequest = onDismissRequest,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SheetHandler()

            ShowPotKoreanText_H1(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.login_subscribe_genre),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(19.dp))

            ShowPotMainButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.login_in_3_seconds)
            ) {
                // TODO: goto Login
            }

            Spacer(modifier = Modifier.height(54.dp))
        }
    }
}

@Composable
fun SubscriptionGenreContent(
    modifier: Modifier,
    innerPadding: PaddingValues,
    genreList: List<Pair<Int, Int>>,
    isSubscribeButtonVisible: Boolean,
    onGenreClick: (Boolean) -> Unit,
    onSubscribeButtonClicked: () -> Unit,
    snackBarHostState: SnackbarHostState,
    scope: CoroutineScope,
) {
    Column(
        modifier = Modifier
            .background(ShowpotColor.Gray700)
            .padding(innerPadding)
            .fillMaxSize(),
    ) {

        ShowPotKoreanText_H2(
            modifier = Modifier.padding(start = 16.dp, top = 5.dp),
            text = stringResource(id = R.string.subscribe_genre_notification),
            color = ShowpotColor.Gray300,
        )

        Spacer(modifier = Modifier.height(14.dp).fillMaxWidth())

        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            LazyVerticalStaggeredGrid(
                state = rememberLazyStaggeredGridState(),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 40.dp,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 48.dp)
            ) {
                items(genreList.size) { index ->
                    val isEvenIndex = index % 2 == 0
                    val (resId, selectedResId) = genreList[index]
                    var isSelected by rememberSaveable { mutableStateOf(false) }
                    val align = if (isEvenIndex) Alignment.TopEnd else Alignment.TopStart

                    val topPadding = if (index == 1) 90.dp else 0.dp
                    val bottomPadding = if (index == genreList.size - 1) 74.dp else 0.dp

                    Box(
                        modifier = Modifier
                            .padding(top = topPadding, bottom = bottomPadding)
                    ) {
                        ShowPotGenre(
                            modifier = Modifier.align(align),
                            enabled = true,
                            icon = painterResource(id = resId),
                            selectedIcon = painterResource(id = selectedResId),
                            isSelected = isSelected,
                            onSelectClicked = {
                                onGenreClick(isSelected)
                                isSelected = !isSelected
                            }
                        )
                    }
                }
            }

            // TODO 진입 시, 그라데이션 높이 제대로 표기 안되는거 수정
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                ShowpotColor.Gray700.copy(alpha = 0f),
                                ShowpotColor.Gray700
                            ),
                        )
                    ).align(Alignment.BottomCenter)
            )

            if (isSubscribeButtonVisible) {
                Box(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .fillMaxWidth()
                        .padding(bottom = 54.dp)
                        .align(Alignment.BottomCenter),
                ) {
                    ShowPotMainButton(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                        text = stringResource(id = R.string.subscribe)
                    ) {
                        scope.launch {
                            onSubscribeButtonClicked()
                            snackBarHostState.showSnackbar("구독 설정이 완료되었습니다")
                        }
                    }
                }
            }
        }
    }
}
