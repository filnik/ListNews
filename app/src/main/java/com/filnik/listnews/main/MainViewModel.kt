package com.filnik.listnews.main

import androidx.lifecycle.ViewModel
import com.filnik.listnews.NewsItem
import com.filnik.listnews.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel() {
    val selectedNews: MutableStateFlow<NewsItem?> = MutableStateFlow(null)
    val newsList = listOf(
        NewsItem(
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
        ),
        NewsItem(
            "Scossa di terremoto del 4.2 a Rovigo",
            R.drawable.terremoto,
            "6 ore fa",
            "L'Istituto nazionale di geofisica e vulcanologia (Ingv) ha rivisto a 4.2 la magnitudo della scossa registrata a un km a est di Ceneselli, in provincia di Rovigo.\n" +
                    "\n" +
                    "La sala sismica Ingc di Roma ha rivisto anche la profondità, individuata tra gli 8 e i 9 chilometri di profondità. La scossa di terremoto si è verificata nei pressi di Calto (Rovigo) alle 15.45. Il sisma è stato avvertito anche a Trieste, Bologna e Modena. Sono in corso le verifiche ma al momento non sono segnalati danni in Veneto o in Emilia Romagna.\n" +
                    "\n" +
                    "Cesenelli è il centro più vicino al terremoto registrato in Veneto alle 15,45. Il sisma, di magnitudo 4,2, è avvenuto alla profondità di 8 chilometri. Lo rileva l'Istituto Nazionale di Geofisica e Vulcanologia. Gli altri comuni più vicini all'epicentro sono Calto (Ro) a 3 chilometri, Felonica (Mn) a 4 chilometri e Salara, a 5 chilometri"
        ),
        NewsItem(
            "Pilota fuori servizio fa precipitare l'aereo di Alaska Airlines",
            R.drawable.aereo,
            "13 ore fa",
            "Paura su un volo di linea dell'Alaska Airlines. Un pilota fuori servizio ha tentato di far precipitare l'aereo, che stava volando sulla tratta Everett-San Francisco. \n" +
                    "\n" +
                    "L'uomo, Joseph David Emerson, 44 anni, era seduto su uno strapuntino nella cabina di pilotaggio, quando improvvisamente si è gettato sui comandi di bordo durante il volo di crociera tentando di spegnere entrambi i motori. Ma è stato bloccato dall'equipaggio, che lo ha ammanettato ed è poi riuscito a far atterrare l'aereo a Portland. \n" +
                    "\n" +
                    "Emerson era in viaggio per San Francisco, dove avrebbe dovuto far parte dell'equipaggio di un 737. Gli sono stati contestati molti capi di imputazione fra i quali 84 tentati omicidi, oltre alla messa in pericolo di un aereo e pericolo sconsiderato.\n" +
                    "\n" +
                    "A quanto riferito dalla compagnia aerea, il pilota fuori servizio era seduto nella cabina di pilotaggio e ''ha tentato senza successo di interrompere il funzionamento dei motori''. Il capitano e il primo ufficiale \"hanno risposto rapidamente\": la potenza del motore non è andata persa e l'equipaggio ha messo in sicurezza l'aereo senza incidenti. A bordo c'erano 80 passeggeri e quattro membri dell'equipaggio, nessuno è rimasto ferito."
        )
    )

    fun openDetails(item: NewsItem) {
        selectedNews.value = item
    }
}