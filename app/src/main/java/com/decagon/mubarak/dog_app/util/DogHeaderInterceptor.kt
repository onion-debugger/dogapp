package com.decagon.mubarak.dog_app.util

import okhttp3.Interceptor
import okhttp3.Response

class DogHeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("x-api-key", dogApiKey)
            .build()
        return chain.proceed(request)
    }
}
