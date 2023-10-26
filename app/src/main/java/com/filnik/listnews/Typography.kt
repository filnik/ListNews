package com.filnik.listnews

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Typography {
    val labelH1 = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 17.sp,
        lineHeight = 15.sp
    )
    val labelH2 = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 15.sp
    )
    val labelText = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 17.sp
    )
    val labelSmallText = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp
    )
}