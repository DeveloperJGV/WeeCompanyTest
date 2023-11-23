package com.aviva.wecompanytest.data.repository

import com.aviva.wecompanytest.BuildConfig
import com.aviva.wecompanytest.data.api.MarvelApiService
import com.aviva.wecompanytest.data.model.Character
import com.aviva.wecompanytest.util.generateMarvelHash

class SuperheroRepository(private val apiService: MarvelApiService) {

    suspend fun getSuperheroes(): List<Character> {
        val timestamp = System.currentTimeMillis().toString()
        val hash = generateMarvelHash(timestamp, BuildConfig.MARVEL_API_KEY_PUBLIC, BuildConfig.MARVEL_API_KEY_PRIVATE)
        val response = apiService.getCharacters(BuildConfig.MARVEL_API_KEY_PUBLIC, timestamp, hash)
        if (response.code == 200) {
            return response.data.results
        }
        // Manejar los casos en que la respuesta no sea 200 OK
        throw Exception("Error fetching superheroes: ${response.status}")
    }
}