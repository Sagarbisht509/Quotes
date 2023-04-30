package com.example.quotes

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.models.Quote
import com.google.gson.Gson

object DataManager {

    var data = emptyArray<Quote>()
    var state = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.MAIN)
    var currentQuote: Quote? = null

    fun loadDataFromJson(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        state.value = true
    }

    fun changeScreen(quote: Quote?) {
        if (currentPage.value == Pages.MAIN) {
            currentQuote = quote
            currentPage.value = Pages.DETAILS
        } else {
            currentPage.value = Pages.MAIN
        }
    }
}