package com.aviva.wecompanytest.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aviva.wecompanytest.R
import com.aviva.wecompanytest.data.api.RetrofitInstance
import com.aviva.wecompanytest.data.repository.SuperheroRepository
import com.aviva.wecompanytest.ui.adapters.ComicAdapter
import com.aviva.wecompanytest.util.Result
import android.widget.ProgressBar
import android.widget.Toast
import com.aviva.wecompanytest.data.model.Character
import com.aviva.wecompanytest.databinding.FragmentHeroDetailsBinding

class HeroDetailsFragment : Fragment() {
    private lateinit var viewModel: HeroDetailViewModel
    private lateinit var viewModelFactory: HeroDetailViewModelFactory
    private lateinit var comicAdapter: ComicAdapter
    private var _binding: FragmentHeroDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val superheroRepository = SuperheroRepository(RetrofitInstance.api)
        val heroId = arguments?.getInt("characterId") ?: 0
        println("Received character ID in HeroDetailsFragment: $heroId")
        viewModelFactory = HeroDetailViewModelFactory(superheroRepository, heroId)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HeroDetailViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHeroDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comicAdapter = ComicAdapter()
        binding.recyclerViewComics.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewComics.adapter = comicAdapter

        viewModel.characterDetails.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {
                    // Muestra un indicador de carga
                }
                is Result.Success -> {
                    // Actualiza la UI con los detalles del personaje
                    if (result.data is Character) {
                        val character = result.data
                        binding.textViewHeroName.text = character.name
                        binding.textViewHeroDescription.text = character.description
                        comicAdapter.updateComics(character.comics.items)
                    }
                }
                is Result.Error -> {
                    // Muestra un mensaje de error
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}