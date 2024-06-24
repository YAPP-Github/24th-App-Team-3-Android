package com.alreadyoccupiedseat.designsystem.preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alreadyoccupiedseat.designsystem.R
import com.alreadyoccupiedseat.designsystem.ShowPotTheme

@Composable
fun IconPreview() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            SectionTitle("48x48")
            IconSection(
                icons = listOf(
                    "ic_check_48" to R.drawable.ic_check_48,
                    "ic_delete_48" to R.drawable.ic_delete_48
                )
            )
        }
        item {
            SectionTitle("36x36")
            IconSection(
                icons = listOf(
                    "ic_magnifier_36" to R.drawable.ic_magnifier_36,
                    "ic_cancel_36" to R.drawable.ic_cancel_36,
                    "ic_plus_36" to R.drawable.ic_plus_36,
                    "ic_filter_36" to R.drawable.ic_filter_36,
                    "ic_alarm_cancel_36" to R.drawable.ic_alarm_cancel_36,
                    "ic_alarm_plus_36" to R.drawable.ic_alarm_plus_36,
                    "ic_setting_36" to R.drawable.ic_setting_36,
                    "ic_delete_36" to R.drawable.ic_delete_36,
                    "ic_heart_36_on" to R.drawable.ic_heart_36_on,
                    "ic_heart_36_off" to R.drawable.ic_heart_36_off,
                    "ic_check_36" to R.drawable.ic_check_36,
                    "ic_arrow_36_right" to R.drawable.ic_arrow_36_right,
                    "ic_arrow_36_down" to R.drawable.ic_arrow_36_down,
                    "ic_arrow_36_left" to R.drawable.ic_arrow_36_left,
                    "ic_arrow_36_up" to R.drawable.ic_arrow_36_up
                )
            )
        }

        item {
            SectionTitle("24x24")
            IconSection(
                icons = listOf(
                    "ic_magnifier_24" to R.drawable.ic_magnifier_24,
                    "ic_plus_24" to R.drawable.ic_plus_24,
                    "ic_check_24" to R.drawable.ic_check_24,
                    "ic_heart_24" to R.drawable.ic_heart_24,
                    "ic_arrow_24_right" to R.drawable.ic_arrow_24_right,
                    "ic_arrow_24_down" to R.drawable.ic_arrow_24_down,
                    "ic_arrow_24_left" to R.drawable.ic_arrow_24_left,
                    "ic_arrow_24_up" to R.drawable.ic_arrow_24_up,
                    "ic_edit_24" to R.drawable.ic_edit_24,
                    "ic_delete_24" to R.drawable.ic_delete_24,
                    "ic_alarm_24_cancel" to R.drawable.ic_alarm_24_cancel,
                    "ic_alarm_24_default" to R.drawable.ic_alarm_24_default,
                    "ic_alarm_24_plus" to R.drawable.ic_alarm_24_plus,
                    "ic_profile_24" to R.drawable.ic_profile_24
                )
            )
        }
    }
}

@Composable
fun IconSection(icons: List<Pair<String, Int>>) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        for (rowIcons in icons.chunked(3)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                for ((iconName, iconRes) in rowIcons) {
                    IconItem(iconName, iconRes)
                }
            }
        }
    }
}

@Composable
fun IconItem(iconName: String, iconRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = iconName,
            modifier = Modifier.size(48.dp)  // 아이콘 크기를 48dp로 설정
        )
        Text(text = iconName, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIconPreview() {
    ShowPotTheme {
        IconPreview()
    }
}