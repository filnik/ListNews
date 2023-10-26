package com.filnik.listnews.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalDensity
import androidx.hilt.navigation.compose.hiltViewModel
import com.filnik.listnews.details.DetailsScreen
import com.filnik.listnews.ui.theme.ListNewsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListNewsTheme {
                val viewModel = hiltViewModel<MainViewModel>()
                val density = LocalDensity.current
                val bottomSheetState =
                    remember { BottomSheetState(BottomSheetValue.Collapsed, density = density) }
                val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
                    bottomSheetState = bottomSheetState
                )
                val scope = rememberCoroutineScope()

                DetailsScreen(
                    bottomSheetScaffoldState = bottomSheetScaffoldState,
                    newsState = viewModel.selectedNews.collectAsState()
                ) {
                    NewsListScreen(viewModel.newsList) { item ->
                        viewModel.openDetails(item)
                        scope.launch {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        }
                    }
                }
            }
        }
    }
}