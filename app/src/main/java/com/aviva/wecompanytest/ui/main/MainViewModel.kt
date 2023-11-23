package com.aviva.wecompanytest.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.aviva.wecompanytest.BuildConfig
import com.aviva.wecompanytest.data.api.RetrofitInstance
import com.aviva.wecompanytest.util.generateMarvelHash
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    // LiveData que expone la lista de superhéroes o un mensaje de error
    val superheroes = liveData(Dispatchers.IO) {
        try {
            val timestamp = System.currentTimeMillis().toString()
            val hash = generateMarvelHash(timestamp, BuildConfig.MARVEL_API_KEY_PUBLIC, BuildConfig.MARVEL_API_KEY_PRIVATE)
            val response = RetrofitInstance.api.getCharacters(BuildConfig.MARVEL_API_KEY_PUBLIC, timestamp, hash)

            if (response.code == 200) {
                emit(response.data.results) // Emite la lista de personajes
            } else {
                emit(emptyList()) // Emite una lista vacía
            }
        } catch (e: Exception) {
            emit(emptyList()) // En caso de una excepción, emite una lista vacía
        }
    }
}