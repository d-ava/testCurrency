package com.example.testtbc

import com.squareup.moshi.Json

data class Currency01(
    @Json(name = "currency")
    val currency: String,
    @Json(name = "value")
    val value: Double
)