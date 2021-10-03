package com.decagon.mubarak.dog_app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.decagon.mubarak.dog_app.data.repository.BreedRepository
import com.decagon.mubarak.dog_app.data.repository.api.DogApiHelper
import java.lang.IllegalArgumentException

class DogViewModelFactory(private val apiHelper: DogApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
            return DogViewModel(BreedRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}