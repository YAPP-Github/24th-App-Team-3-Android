package com.alreadyoccupiedseat.designsystem.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.unit.sp
import com.alreadyoccupiedseat.core.extention.toHexString
import com.alreadyoccupiedseat.designsystem.ShowPotTheme
import com.alreadyoccupiedseat.designsystem.ShowpotColor

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
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .background(ShowpotColor.Gray100)
    )
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
        Text(
            text = colorName,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 8.sp,
            )
        )
        Text(
            text = color.toHexString(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 5.sp
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