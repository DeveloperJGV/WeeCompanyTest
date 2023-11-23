package com.aviva.wecompanytest.di

import com.aviva.wecompanytest.data.api.MarvelApiService
import com.aviva.wecompanytest.data.api.RetrofitInstance
import com.aviva.wecompanytest.data.repository.SuperheroRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideMarvelApiService(): MarvelApiService {
        return RetrofitInstance.api
    }

    @Provides
    fun provideSuperheroRepository(apiService: MarvelApiService): SuperheroRepository {
        return SuperheroRepository(apiService)
    }
}
