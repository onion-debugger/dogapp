package com.decagon.mubarak.dog_app.data.repository.api

import com.decagon.mubarak.dog_app.data.repository.model.Breeds
import retrofit2.http.GET

interface DogApiService {

    @GET("breeds")
    suspend fun getBreeds(): List<Breeds>

    @GET("")
    suspend fun getDogImages(): List<String>
}
