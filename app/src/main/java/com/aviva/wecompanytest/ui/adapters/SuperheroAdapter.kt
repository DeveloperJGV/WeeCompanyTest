package com.aviva.wecompanytest.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aviva.wecompanytest.R
import com.aviva.wecompanytest.data.Superhero

class SuperheroAdapter(private val superheroList: List<Superhero>) : RecyclerView.Adapter<SuperheroAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewSuperhero)
        val textViewName: TextView = view.findViewById(R.id.textViewSuperheroName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val superhero = superheroList[position]
        // Aquí debes cargar la imagen del superhéroe en el imageView
        holder.textViewName.text = superhero.name
    }

    override fun getItemCount() = superheroList.size
}
