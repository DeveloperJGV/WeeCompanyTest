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
        holder.itemView.setOnClickListener {
            // Aquí usamos holder.itemView.context para obtener el context
            val intent = Intent(holder.itemView.context, HeroDetailsActivity::class.java).apply {
                putExtra("HERO_ID", superhero.id) // Pasar el ID del superhéroe
            }
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = superheroList.size
}
