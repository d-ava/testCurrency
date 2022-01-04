package com.example.testtbc.network

import androidx.viewbinding.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkClient {
    private const val BASE_URL = "https://test-api.tbcbank.ge/v1/"


    private val client = OkHttpClient.Builder().apply {
        addInterceptor(MyInterceptor02())
    }.build()

    private fun loggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    private fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(loggingInterceptor)
        return builder.build()
    }

    private fun moshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
//            .client(okHttpClient(loggingInterceptor()))
            .addConverterFactory(MoshiConverterFactory.create(moshi()))
            .build()
    }

    val api: CurrencyApi by lazy {
        retrofit.create(CurrencyApi::class.java)
    }


//    fun retrofit(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit.Builder{
//        return Retrofit.Builder().baseUrl(BASE_URL)
//            .client(okHttpClient)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//    }



//    fun api (retrofit: Retrofit.Builder): CurrencyApi {
//        return retrofit.build().create(CurrencyApi::class.java)
//    }

}