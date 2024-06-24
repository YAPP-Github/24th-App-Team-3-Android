package com.alreadyoccupiedseat.core.extention

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

fun Color.toHexString(): String = String.format("0x%08X", this.toArgb())