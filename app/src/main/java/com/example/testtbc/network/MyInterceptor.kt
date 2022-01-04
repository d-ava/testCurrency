package com.example.testtbc.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

//class MyInterceptor : Interceptor {
//
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request: Request = chain.request()
//
//            .newBuilder()
//            .addHeader("Accept", "application/json")
//            .addHeader("apikey", "7tmMH0B4OEqJqfspTiPFL89JafPKrt6g")
//            .build()
//
//        return chain.proceed(request)
//
//    }
//}

var client = OkHttpClient()

class MyInterceptor02: Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = Request.Builder()
            .url("https://test-api.tbcbank.ge/v1/exchange-rates/nbg")
            .get()
            .addHeader("Accept", "application/json")
            .addHeader("apikey", "7tmMH0B4OEqJqfspTiPFL89JafPKrt6g")
            .build()

        var response: Response = client.newCall(request).execute()
        return response
    }
}


//var client = OkHttpClient()
//
//var request: Request = Builder()
//    .url("https://test-api.tbcbank.ge/v1/exchange-rates/nbg?currency=usd&date=2021-01-01")
//    .get()
//    .addHeader("Accept", "application/json")
//    .addHeader("apikey", "7tmMH0B4OEqJqfspTiPFL89JafPKrt6g")
//    .build()
//
//var response: Response = client.newCall(request).execute()



