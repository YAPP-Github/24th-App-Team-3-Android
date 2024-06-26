package com.alreadyoccupiedseat.designsystem.preview

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alreadyoccupiedseat.designsystem.typo.english.ShowPotEnglishText_H0
import com.alreadyoccupiedseat.designsystem.typo.english.ShowPotEnglishText_H1
import com.alreadyoccupiedseat.designsystem.typo.english.ShowPotEnglishText_H2
import com.alreadyoccupiedseat.designsystem.typo.english.ShowPotEnglishText_H3
import com.alreadyoccupiedseat.designsystem.typo.english.ShowPotEnglishText_H4
import com.alreadyoccupiedseat.designsystem.typo.english.ShowPotEnglishText_H5
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_B1_Regular
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_B1_SemiBold
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_B2_Regular
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_B2_SemiBold
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_B3_Regular
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_B3_SemiBold
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H0
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H1
import com.alreadyoccupiedseat.designsystem.typo.korean.ShowPotKoreanText_H2

@Composable
fun TypographyPreview() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            ShowPotKoreanText_H0(text = "한국어! <- H0")
        }

        item {
            ShowPotKoreanText_H1(text = "한국어 H1")
        }

        item {
            ShowPotKoreanText_H2(text = "한국어 H2")
        }

        item {
            ShowPotKoreanText_B1_SemiBold(text = "한국어 B1_SemiBold")
        }

        item {
            ShowPotKoreanText_B2_SemiBold(text = "한국어 B2_SemiBold")
        }

        item {
            ShowPotKoreanText_B3_SemiBold(text = "한국어 B3_SemiBold")
        }

        item {
            ShowPotKoreanText_B1_Regular(text = "한국어 B1_Regular")
        }

        item {
            ShowPotKoreanText_B2_Regular(text = "한국어 B2_Regular")
        }

        item {
            ShowPotKoreanText_B3_Regular(text = "한국어 B3_Regular")
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            ShowPotEnglishText_H0(text = "English! <- H0")
        }

        item {
            ShowPotEnglishText_H1(text = "English H1")
        }

        item {
            ShowPotEnglishText_H2(text = "English H2")
        }

        item {
            ShowPotEnglishText_H3(text = "English H3")
        }

        item {
            ShowPotEnglishText_H4(text = "English H4")
        }

        item {
            ShowPotEnglishText_H5(text = "English H5")
        }
    }
}