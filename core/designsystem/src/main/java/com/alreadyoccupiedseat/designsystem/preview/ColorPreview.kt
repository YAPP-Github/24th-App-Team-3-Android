package com.alreadyoccupiedseat.designsystem.preview

import android.widget.GridLayout.Spec
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.alreadyoccupiedseat.core.extention.toHexString
import com.alreadyoccupiedseat.designsystem.ShowPotTheme
import com.alreadyoccupiedseat.designsystem.ShowpotColor
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_B3_Regular
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_B3_SemiBold

@Composable
fun ColorPreview() {
    Column {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                listOf(
                    "MainRed" to ShowpotColor.MainRed,
                    "MainGreen" to ShowpotColor.MainGreen,
                    "MainYellow" to ShowpotColor.MainYellow,
                    "MainBlue" to ShowpotColor.MainBlue
                )
            ) { (colorName, color) ->
                ColorItem(colorName, color)
            }
            items(
                listOf(
                    "White" to ShowpotColor.White,
                    "Gray100" to ShowpotColor.Gray100,
                    "Gray200" to ShowpotColor.Gray200,
                    "Gray300" to ShowpotColor.Gray300,
                    "Gray400" to ShowpotColor.Gray400,
                    "Gray500" to ShowpotColor.Gray500,
                    "Gray600" to ShowpotColor.Gray600,
                    "Gray700" to ShowpotColor.Gray700,
                    "Gray800" to ShowpotColor.Gray800
                )
            ) { (colorName, color) ->
                ColorItem(colorName, color)
            }
            items(listOf("ErrorRed" to ShowpotColor.ErrorRed)) { (colorName, color) ->
                ColorItem(colorName, color)
            }
            items(
                listOf(
                    "YES24" to ShowpotColor.YES24,
                    "Interpark" to ShowpotColor.Interpark,
                    "Melon" to ShowpotColor.Melon,
                    "Wemakeprice" to ShowpotColor.Wemakeprice
                )
            ) { (colorName, color) ->
                ColorItem(colorName, color)
            }
        }
    }
}

@Composable
fun ColorItem(colorName: String, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(color)
        )
        ShowPotKoreanText_B3_SemiBold(
            text = colorName,
            color = color,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.height(10.dp))
        ShowPotKoreanText_B3_Regular(
            text = color.toHexString(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewColorPreview() {
    ShowPotTheme {
        ColorPreview()
    }
}