package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.quotes.screens.QuoteDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadDataFromJson(applicationContext)
        }

        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.state.value) {
        if (DataManager.currentPage.value == Pages.MAIN) {
            QuoteListScreen(DataManager.data) {
                DataManager.changeScreen(it)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetails(quote = it) }
        }
    } else {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Loading..."
            )
        }
    }
}