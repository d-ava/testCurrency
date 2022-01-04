package com.example.testtbc


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class Currency : ArrayList<Currency.CurrencyItem>(){
    @JsonClass(generateAdapter = true)
    data class CurrencyItem(
        @Json(name = "currency")
        val currency: String,
        @Json(name = "value")
        val value: Double
    )
}