package com.filnik.listnews.main

import androidx.lifecycle.ViewModel
import com.filnik.listnews.NewsItem
import com.filnik.listnews.domain.NewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    newsListUseCase: NewsListUseCase
) : ViewModel() {
    val selectedNews: MutableStateFlow<NewsItem?> = MutableStateFlow(null)
    var newsList = newsListUseCase.execute()

    fun openDetails(item: NewsItem) {
        selectedNews.value = item
    }
}