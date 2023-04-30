package com.example.quotes.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quotes.models.Quote

@Composable
fun QuoteItem(quote: Quote, onClick: (quote: Quote) -> Unit) {
    Card(
        elevation = 10.dp,
        modifier = Modifier
            .padding(10.dp)
            .clickable { onClick(quote) }
    ) {
        Row(
            modifier = Modifier.padding(15.dp)
        ) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                contentDescription = "quote",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .background(color = Color.Black)
                    .size(25.dp)
                    .rotate(180F)
            )
            Column(
                modifier = Modifier
                    .padding(5.dp, 0.dp, 0.dp, 0.dp)
                    .weight(1f)
            ) {
                Text(
                    text = quote.text,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(.3f)
                        .background(Color.DarkGray)
                        .height(1.dp)
                        .align(Alignment.End)
                )
                Text(
                    text = "~ " + quote.author,
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .align(Alignment.End)
                )
            }
        }
    }
}