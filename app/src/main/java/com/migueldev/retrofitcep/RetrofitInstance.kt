package com.migueldev.retrofitcep

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api: ViaCepApi by lazy {
        retrofit.create(ViaCepApi::class.java)
    }
}