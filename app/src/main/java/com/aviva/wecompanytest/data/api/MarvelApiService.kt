package com.aviva.wecompanytest.data.api

import com.aviva.wecompanytest.data.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {
    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String,
        @Query("ts") timestamp: String,
        @Query("hash") hash: String
    ): ApiResponse
}