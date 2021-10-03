package com.decagon.mubarak.dog_app.data.repository.api

class DogApiHelper(private val apiService: DogApiService) {
    suspend fun getBreeds() = apiService.getBreeds()
}
