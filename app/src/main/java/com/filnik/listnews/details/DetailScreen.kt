package com.filnik.listnews.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.filnik.listnews.NewsItem
import com.filnik.listnews.R
import com.filnik.listnews.Typography

@Composable
fun DetailScreen(newsItem: NewsItem?) {
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
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun DetailScreenPreview() {
    DetailScreen(newsItem = NewsItem(
        "Il Milan cade a Parigi: il Psg vince 3-0",
        R.drawable.calcio,
        "1 ora fa",
        "Il Milan cade a Parigi: il Psg vince 3-0 e si prende il primo posto nel gruppo F di Champions League. I meme dei tifosi Il Milan cade a Parigi: il Psg vince 3-0 e si prende il primo posto nel gruppo F di Champions League. Per i rossoneri la sconfitta pesa e sui social i tifosi si infiammano: ecco le reazioni da Gazzetta TV. Da non facciamo un gol da tre partite al confronto tra Leao e Mbappé passando ai commenti su Pioli\nLa notizia riportata su altre testate\n" +
                "\n" +
                "Pierre Kalulu è intervenuto ai microfoni di Milan TV dopo la pesante sconfitta in casa del PSG. Queste le parole del difensore francese: \"In questo tipo di partite sono gli episodi a fare la differenza. (Milan News)\n" +
                "\n" +
                "Ai microfoni di ‘Amazon Prime Video’, Stefano Pioli ha analizzato la pesante sconfitta patita dal Milan contro il Psg (CalcioMercato.it)\n" +
                "\n" +
                "Fabio Barera Redattore Fikayo Tomori, giocatore rossonero, ha parlato a 'Prime Video' al termine di PSG-Milan, partita della terza giornata del Gruppo F della Champions League 2023-2024 che si è svolta al 'Parco dei Principi' di Parigi (Pianeta Milan)"
    )
    )
}