package com.decagon.mubarak.dog_app.data.repository.api

import com.decagon.mubarak.dog_app.util.DogHeaderInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://api.TheDogAPI.com/v1/"
    private val client = OkHttpClient.Builder()
        .addInterceptor(DogHeaderInterceptor())
        .build()

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: DogApiService = getRetrofit().create(DogApiService::class.java)
}
