package com.aviva.wecompanytest.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aviva.wecompanytest.R

class HeroDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_details)

        // Recuperar el ID del superhéroe pasado a través del Intent
        val heroId = intent.getIntExtra("HERO_ID", -1) // Usa un valor predeterminado en caso de que no se encuentre

        if (heroId != -1) {
            // Utiliza el ID para cargar los detalles del superhéroe
        } else {
            // Manejar la situación de que el ID no se pasó correctamente
        }
    }
}