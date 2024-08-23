package com.alreadyoccupiedseat.myfavorite_show

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
fun MyFavoriteShowTopBar(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit,
) {
    ShowPotTopBar(
        navigationIcon = {
            IconButton(onClick = { onBackClicked() }) {
                Icon(
                    tint = ShowpotColor.White,
                    modifier = Modifier.padding(1.dp),
                    painter = painterResource(id = R.drawable.ic_arrow_36_left),
                    contentDescription = "Back"
                )
            }
        },
        title = {
            ShowPotKoreanText_H1(
                text = stringResource(id = R.string.favorite_show),
                color = ShowpotColor.Gray300,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .padding(vertical = 7.dp)
            )
        },
        contentColor = ShowpotColor.Gray700,
    )
}