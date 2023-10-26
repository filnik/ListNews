package com.filnik.listnews.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.filnik.listnews.R
import com.filnik.listnews.Typography
import com.filnik.listnews.main.MainViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailsScreen(
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    viewModel: MainViewModel,
    content: @Composable (PaddingValues) -> Unit
) {
    val newsItem = viewModel.selectedNews.collectAsState().value
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        sheetElevation = 16.dp,
        sheetContent = {
            if (newsItem == null) {
                Text(text = stringResource(R.string.loading))
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .padding(16.dp)
                ) {
                    item {
                        Text(text = newsItem.title, style = Typography.labelH1)
                        Spacer(modifier = Modifier.height(8.dp))
                        Image(
                            painter = painterResource(id = newsItem.image),
                            contentDescription = "",
                            modifier = Modifier
                                .align(CenterHorizontally)
                                .width(400.dp)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = newsItem.description,
                            style = Typography.labelText,
                            color = Color.DarkGray
                        )
                    }
                }
            }
        },
        sheetPeekHeight = 0.dp,
        content = content
    )
}