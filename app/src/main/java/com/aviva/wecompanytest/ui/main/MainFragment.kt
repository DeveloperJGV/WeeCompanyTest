package com.aviva.wecompanytest.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.aviva.wecompanytest.R
import com.aviva.wecompanytest.ui.adapters.SuperheroAdapter
import com.aviva.wecompanytest.util.Result
import androidx.fragment.app.viewModels
import android.widget.ProgressBar
import android.widget.Toast
import com.aviva.wecompanytest.data.model.Character

class MainFragment : Fragment() {

    // Crear una instancia del adaptador
    private lateinit var superheroAdapter: SuperheroAdapter

    // ViewModel
    private val viewModel: MainViewModel by viewModels()

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
        superheroAdapter = SuperheroAdapter { character: Character ->
            // Aquí puedes manejar el evento de clic en cada personaje
            Toast.makeText(context, "Clicked on: ${character.name}", Toast.LENGTH_SHORT).show()
        }
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
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
