package com.alreadyoccupiedseat.designsystem.preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alreadyoccupiedseat.designsystem.ErrorRed
import com.alreadyoccupiedseat.designsystem.Gray100
import com.alreadyoccupiedseat.designsystem.Gray200
import com.alreadyoccupiedseat.designsystem.Gray300
import com.alreadyoccupiedseat.designsystem.Gray400
import com.alreadyoccupiedseat.designsystem.Gray500
import com.alreadyoccupiedseat.designsystem.Gray600
import com.alreadyoccupiedseat.designsystem.Gray700
import com.alreadyoccupiedseat.designsystem.Gray800
import com.alreadyoccupiedseat.designsystem.Interpark
import com.alreadyoccupiedseat.designsystem.MainBlue
import com.alreadyoccupiedseat.designsystem.MainGreen
import com.alreadyoccupiedseat.designsystem.MainRed
import com.alreadyoccupiedseat.designsystem.MainYellow
import com.alreadyoccupiedseat.designsystem.Melon
import com.alreadyoccupiedseat.designsystem.ShowPotTheme
import com.alreadyoccupiedseat.designsystem.Wemakeprice
import com.alreadyoccupiedseat.designsystem.White
import com.alreadyoccupiedseat.designsystem.YES24

@Composable
fun ColorPreview() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Text("확정 컬러", style = MaterialTheme.typography.headlineLarge)
        }
        item {
            SectionTitle("Primary Brand Color")
            ColorSection(
                listOf(
                    "MainRed" to MainRed,
                    "MainGreen" to MainGreen,
                    "MainYellow" to MainYellow,
                    "MainBlue" to MainBlue
                )
            )
        }
        item {
            SectionTitle("Object, Line, Text Color")
            ColorSection(
                listOf(
                    "White" to White,
                    "Gray100" to Gray100,
                    "Gray200" to Gray200,
                    "Gray300" to Gray300,
                    "Gray400" to Gray400,
                    "Gray500" to Gray500,
                    "Gray600" to Gray600,
                    "Gray700" to Gray700,
                    "Gray800" to Gray800
                )
            )
        }
        item {
            SectionTitle("Error Color")
            ColorSection(listOf("ErrorRed" to ErrorRed))
        }

        item {
            SectionTitle("Chip Color")
            ColorSection(
                listOf(
                    "YES24" to YES24,
                    "Interpark" to Interpark,
                    "Melon" to Melon,
                    "Wemakeprice" to Wemakeprice
                )
            )
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
            .background(Gray100)
    )
}

@Composable
fun ColorSection(colors: List<Pair<String, Color>>) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        for (rowColors in colors.chunked(4)) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                for ((colorName, color) in rowColors) {
                    ColorItem(colorName, color)
                }
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
        Text(text = colorName, fontSize = 12.sp, modifier = Modifier.padding(top = 4.dp))
        Text(text = colorToHex(color), fontSize = 10.sp, modifier = Modifier.padding(top = 2.dp))
    }
}

fun colorToHex(color: Color): String {
    return String.format("0x%08X", color.toArgb())
}

@Preview(showBackground = true)
@Composable
fun PreviewColorPreview() {
    ShowPotTheme {
        ColorPreview()
    }
}