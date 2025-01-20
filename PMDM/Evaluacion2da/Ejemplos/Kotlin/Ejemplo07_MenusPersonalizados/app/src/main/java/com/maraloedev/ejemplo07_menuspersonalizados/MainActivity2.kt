package com.maraloedev.ejemplo07_menuspersonalizados

import android.os.Bundle
import com.maraloedev.ejemplo07_menuspersonalizados.databinding.ActivityMain2Binding

class MainActivity2 : GestionMenus() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Asignar el contexto al layout principal de la segunda actividad
        contexto = binding.llFondoActivity2

        // Registrar el layout principal para el menú contextual
        registerForContextMenu(binding.llFondoActivity2)

        // Configurar la barra de herramientas y asignar un título
        setSupportActionBar(binding.toolbar.miToolbar)
        supportActionBar?.title = "Menús Activity 2"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Método para manejar la navegación hacia arriba en la barra de herramientas
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}