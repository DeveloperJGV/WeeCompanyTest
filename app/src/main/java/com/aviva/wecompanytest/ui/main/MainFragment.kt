package com.aviva.wecompanytest.ui.main

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
import com.aviva.wecompanytest.ui.adapters.SuperheroAdapter
import com.aviva.wecompanytest.util.Result
import android.widget.ProgressBar
import android.widget.Toast
import com.aviva.wecompanytest.data.model.Character

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var viewModelFactory: MainViewModelFactory
    private lateinit var superheroAdapter: SuperheroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inicialización del repositorio y la fábrica de ViewModel
        val superheroRepository = SuperheroRepository(RetrofitInstance.api)
        viewModelFactory = MainViewModelFactory(superheroRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar el RecyclerView y el adaptador
        val navController = findNavController()
        superheroAdapter = SuperheroAdapter { character: Character ->
            // Manejo del clic en cada personaje
            val action = MainFragmentDirections.actionMainFragmentToHeroDetailsFragment(character.id)
            navController.navigate(action)
            println("Navigating to HeroDetailsFragment with character ID: ${character.id}")

        }

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context) // Asignación del LayoutManager
        recyclerView.adapter = superheroAdapter

        // Observar los cambios del ViewModel
        viewModel.superheroes.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Result.Loading -> {
                    view.findViewById<ProgressBar>(R.id.progressBar).visibility = View.VISIBLE
                }
                is Result.Success -> {
                    view.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
                    superheroAdapter.submitList(result.data)
                }
                is Result.Error -> {
                    view.findViewById<ProgressBar>(R.id.progressBar).visibility = View.GONE
                    Toast.makeText(context, "Error: ${result.exception.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
