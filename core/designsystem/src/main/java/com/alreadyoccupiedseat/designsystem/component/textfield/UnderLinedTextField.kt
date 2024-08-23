package com.alreadyoccupiedseat.designsystem.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import com.alreadyoccupiedseat.core.extension.EMPTY
import com.alreadyoccupiedseat.core.extension.conditional
import com.alreadyoccupiedseat.designsystem.ShowPotTypography
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_B1_Regular

@Composable
fun UnderLinedTextField(
    modifier: Modifier = Modifier,
    hint: String = String.EMPTY,
    inputText: String = String.EMPTY,
    enabled: Boolean = true,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onClickedWhenDisEnabled: () -> Unit = {},
    onTextChanged: (String) -> Unit = {},
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp)
            .background(color = ShowpotColor.Gray700)
            .conditional(enabled.not()) {
                clickable {
                    onClickedWhenDisEnabled()
                }
            }
            .padding(horizontal = 8.dp)
            .padding(top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = inputText,
            enabled = enabled,
            onValueChange = { newString ->
                onTextChanged(newString)
            },
            textStyle = ShowPotTypography.Korean.B1_regular.copy(color = ShowpotColor.Gray100),
            cursorBrush = SolidColor(ShowpotColor.Gray100),
            singleLine = true,
            keyboardActions = keyboardActions,
        ) { innerTextField ->
            innerTextField()

            // hint section
            if (inputText.isEmpty()) {
                ShowPotKoreanText_B1_Regular(
                    text = hint,
                    color = ShowpotColor.Gray300
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Spacer(
            modifier = Modifier
                .fillMaxWidth().height(1.dp)
                .background(ShowpotColor.Gray500)
        )
    }
}