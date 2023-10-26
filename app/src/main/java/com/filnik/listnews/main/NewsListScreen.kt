package com.filnik.listnews.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.filnik.listnews.NewsItem
import com.filnik.listnews.R
import com.filnik.listnews.Typography

@Composable
fun NewsListScreen(newsList: List<NewsItem>, onItemClick: (NewsItem) -> Unit) {
    Column {
        Text(
            text = stringResource(R.string.local_news),
            color = colorResource(id = R.color.title),
            style = Typography.labelH1,
            modifier = Modifier.padding(8.dp)
        )
        LazyColumn {
            items(newsList) { item ->
                NewsItemRow(item, onItemClick)
                Divider(color = Color.Gray, modifier = Modifier.padding(horizontal = 8.dp))
            }
        }
    }
}

@Composable
fun NewsItemRow(item: NewsItem, onItemClick: (NewsItem) -> Unit) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick(item) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(item.title, style = Typography.labelH2)
            Spacer(modifier = Modifier.height(4.dp))
            Text(item.time, style = Typography.labelSmallText, color = Color.Gray)
        }
        Spacer(Modifier.weight(0.1f))
        Image(
            painter = painterResource(id = item.image),
            contentDescription = null,
            modifier = Modifier
                .width(90.dp)
        )
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun NewsListPreview() {
    NewsListScreen(
        listOf(
            NewsItem(
                "Il Milan cade a Parigi: il Psg vince 3-0",
                R.drawable.calcio,
                "1 ora fa", ""
            ),
            NewsItem(
                "Scossa di terremoto del 4.2 a Rovigo, avvertita da Trieste a Bologna",
                R.drawable.terremoto,
                "6 ore fa", ""
            ),
            NewsItem(
                "Pilota fuori servizio tenta di far precipitare l'aereo dell'Alaska Airlines",
                R.drawable.aereo,
                "13 ore fa", ""
            )
        )
    ) { }
}