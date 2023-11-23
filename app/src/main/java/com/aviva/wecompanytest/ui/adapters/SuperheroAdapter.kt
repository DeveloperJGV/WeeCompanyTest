package com.aviva.wecompanytest.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aviva.wecompanytest.R
import com.aviva.wecompanytest.data.model.Superhero
import com.aviva.wecompanytest.ui.details.HeroDetailsActivity


class SuperheroAdapter(
    private val superheroList: List<Superhero>,
    private val onClick: (Superhero) -> Unit
) : RecyclerView.Adapter<SuperheroAdapter.ViewHolder>() {

    class ViewHolder(view: View, val onClick: (Superhero) -> Unit) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewSuperhero)
        val textViewName: TextView = view.findViewById(R.id.textViewSuperheroName)
        private var currentSuperhero: Superhero? = null

        init {
            view.setOnClickListener {
                currentSuperhero?.let {
                    onClick(it)
                }
            }
        }

        fun bind(superhero: Superhero) {
            currentSuperhero = superhero
            // Aquí puedes configurar la imagen y el nombre
            textViewName.text = superhero.name
            // imageView.setImage... // Configurar la imagen utilizando Picasso o Glide
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superhero = superheroList[position]
        holder.bind(superhero)
    }

    override fun getItemCount() = superheroList.size
}