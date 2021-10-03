package com.decagon.mubarak.dog_app.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.decagon.mubarak.dog_app.data.repository.BreedRepository
import com.decagon.mubarak.dog_app.util.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class DogViewModel(private val repository: BreedRepository) : ViewModel() {

    fun getBreeds() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getBreeds()))
            Log.d("DogViewModel", "getBreeds: ${repository.getBreeds()}")
        } catch (exception: Exception) {
            emit(
                Resource.error(
                    data = null,
                    message = exception.message
                        ?: "Error Occurred!"
                )
            )
        }
    }
}
