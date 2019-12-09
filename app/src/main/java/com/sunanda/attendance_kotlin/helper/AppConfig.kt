package com.sunanda.attendance_kotlin.helper

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppConfig {

    private const val BASE_URL = "http://13.232.198.224/routine/public/"
    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}