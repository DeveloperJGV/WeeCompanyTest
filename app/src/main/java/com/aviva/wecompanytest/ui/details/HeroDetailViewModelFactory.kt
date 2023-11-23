package com.aviva.wecompanytest.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aviva.wecompanytest.data.repository.SuperheroRepository

class HeroDetailViewModelFactory(private val superheroRepository: SuperheroRepository, private val characterId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HeroDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HeroDetailViewModel(superheroRepository, characterId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}