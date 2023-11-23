package com.aviva.wecompanytest.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aviva.wecompanytest.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // No se necesita más lógica aquí, ya que MainFragment manejará la UI
    }
}
