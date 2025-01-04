package com.example.techexactlyassingments.networking.retrofit

import com.example.techexactlyassingments.networking.api_services.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val loggingInterceptor by lazy {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://navkiraninfotech.com/g-mee-api/api/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}