package com.aviva.wecompanytest.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aviva.wecompanytest.data.repository.SuperheroRepository
import com.aviva.wecompanytest.util.Result
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val superheroRepository: SuperheroRepository) : ViewModel() {

    val superheroes = liveData(Dispatchers.IO) {
        emit(Result.Loading) // Emite el estado de carga
        try {
            val data = superheroRepository.getSuperheroes()
            emit(Result.Success(data)) // Emite el resultado exitoso con los datos
        } catch (e: Exception) {
            emit(Result.Error(e)) // Emite un error si algo sale mal
        }
    }
}
