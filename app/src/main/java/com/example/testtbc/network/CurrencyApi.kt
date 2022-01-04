package com.example.testtbc.network

import com.example.testtbc.Currency01
import retrofit2.Response
import retrofit2.http.GET

interface CurrencyApi {
    @GET("exchange-rates/nbg")
    suspend fun getCurrency():Response<List<Currency01>>

}