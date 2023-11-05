package com.filnik.listnews.details

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.unit.dp
import com.filnik.listnews.NewsItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsScreen(
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    newsState: State<NewsItem?>,
    content: @Composable (PaddingValues) -> Unit
) {
    val newsItem = newsState.value
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetElevation = 16.dp,
        sheetContent = {
            DetailScreen(newsItem)
        },
        sheetPeekHeight = 0.dp,
        content = content
    )
}