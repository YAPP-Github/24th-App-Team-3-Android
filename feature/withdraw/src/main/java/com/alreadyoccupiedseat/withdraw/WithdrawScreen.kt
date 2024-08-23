package com.alreadyoccupiedseat.withdraw

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.component.ShowPotButton
import com.alreadyoccupiedseat.designsystem.component.bottomSheet.SheetHandler
import com.alreadyoccupiedseat.designsystem.component.bottomSheet.ShowPotBottomSheet
import com.alreadyoccupiedseat.designsystem.component.button.ShowPotSubButton
import com.alreadyoccupiedseat.designsystem.component.textfield.UnderLinedTextField
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H1
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H2

@Composable
fun WithDrawScreen(
    navController: NavController
) {

    val viewModel = hiltViewModel<WithDrawViewModel>()
    val state = viewModel.state.collectAsState()

    WithDrawScreenContent(
        state = state.value,
        onBackClicked = {
            navController.popBackStack()
        },
        onTextChanged = { newString ->
            viewModel.updateInputText(newString)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WithDrawScreenContent(
    state: WithDrawScreenState,
    onBackClicked: () -> Unit,
    onTextChanged: (String) -> Unit
) {

    // TODO: Supposed to be in a ViewModel State
    var isSheetVisible by remember { mutableStateOf(false) }

    if (isSheetVisible) {

        ShowPotBottomSheet(
            onDismissRequest = {
                isSheetVisible = false
            },
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                SheetHandler()

                Spacer(modifier = Modifier.height(3.dp))

                ShowPotKoreanText_H2(
                    modifier = Modifier.fillMaxWidth(),
                    text = "탈퇴 하시면, 계정과 관련된 모든 정보가 삭제되며\n" +
                            "복구할 수 없어요. 탈퇴하시겠습니까?",
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(22.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    ShowPotSubButton(
                        modifier = Modifier.weight(1f),
                        text = "취소",
                        onClicked = {
                            isSheetVisible = false
                        },
                    )
                    ShowPotSubButton(
                        modifier = Modifier.weight(1f),
                        text = "탈퇴하기",
                        onClicked = {
                            // TODO: request withdraw
                        },
                    )

                }

                Spacer(modifier = Modifier.height(54.dp))
            }
        }

    }

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
                    text = "회원 탈퇴 ",
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

            Spacer(modifier = Modifier.height(31.dp))

            UnderLinedTextField(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 14.dp),
                hint = "구체적인 사유를 입력해주세요.",
                inputText = state.inputText,
                onTextChanged = { onTextChanged(it) }
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 55.dp),
                contentAlignment = Alignment.BottomCenter
            ) {

                ShowPotButton(
                    modifier = Modifier
                        .padding(horizontal = 14.dp)
                        .fillMaxWidth()
                        .height(55.dp),
                    onClick = {
                        isSheetVisible = true
                    },
                    enabled = state.inputText.isNotEmpty(),
                    shape = RoundedCornerShape(2.dp),
                    colors = ButtonColors(
                        containerColor = ShowpotColor.Gray500,
                        contentColor = Color.White,
                        disabledContainerColor = ShowpotColor.Gray600,
                        disabledContentColor = ShowpotColor.Gray400,
                    ),
                ) {
                    ShowPotKoreanText_H2(
                        text = "제출하고 탈퇴하기",
                        color = if (state.inputText.isNotEmpty()) ShowpotColor.White else ShowpotColor.Gray400,
                    )
                }
            }
        }
    }
}

