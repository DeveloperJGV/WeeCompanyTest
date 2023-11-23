package com.aviva.wecompanytest.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aviva.wecompanytest.R
import com.aviva.wecompanytest.data.model.Character
import com.squareup.picasso.Picasso

class SuperheroAdapter(
    private var characterList: List<Character> = emptyList(),
    private val onClick: (Character) -> Unit
) : RecyclerView.Adapter<SuperheroAdapter.ViewHolder>() {

    class ViewHolder(view: View, val onClick: (Character) -> Unit) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageViewSuperhero)
        val textViewName: TextView = view.findViewById(R.id.textViewSuperheroName)
        private var currentCharacter: Character? = null

        init {
            view.setOnClickListener {
                currentCharacter?.let(onClick)
            }
        }

        fun bind(character: Character) {
            currentCharacter = character
            textViewName.text = character.name
            // Utiliza Picasso para cargar la imagen del personaje
            Picasso.get()
                .load(character.thumbnail.getUrl())
                .into(imageView)
        }
    }

    // Método para actualizar la lista de personajes
    fun submitList(characters: List<Character>) {
        characterList = characters
        notifyDataSetChanged() // Notifica al adaptador que los datos han cambiado
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        return ViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = characterList[position]
        holder.bind(character)
    }

    override fun getItemCount() = characterList.size
}
