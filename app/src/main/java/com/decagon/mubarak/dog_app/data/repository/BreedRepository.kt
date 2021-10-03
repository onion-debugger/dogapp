package com.decagon.mubarak.dog_app.data.repository

import com.decagon.mubarak.dog_app.data.repository.api.DogApiHelper

class BreedRepository(private val apiHelper: DogApiHelper) {

    suspend fun getBreeds() = apiHelper.getBreeds()
}
