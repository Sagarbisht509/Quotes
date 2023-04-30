package com.example.quotes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotes.models.Quote
import com.example.quotes.screens.QuoteItem

@Composable
fun QuoteList(data : Array<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn(content = {
        items(data) {
            QuoteItem(quote = it, onClick)
        }
    })
}