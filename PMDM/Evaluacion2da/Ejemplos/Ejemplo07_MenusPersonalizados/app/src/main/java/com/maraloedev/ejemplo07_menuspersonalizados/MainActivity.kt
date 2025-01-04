package com.maraloedev.ejemplo07_menuspersonalizados

import android.content.Intent
import android.os.Bundle
import com.maraloedev.ejemplo07_menuspersonalizados.databinding.ActivityMainBinding


class MainActivity : GestionMenus() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Asignar el contexto al layout principal
        contexto = binding.llPrincipal

        // Configurar el listener para el botón que inicia MainActivity2
        binding.bPasarActivity.setOnClickListener(){
            val intentSegundo: Intent = Intent(this, MainActivity2::class.java)
            startActivity(intentSegundo)
        }

        // Registrar el layout principal para el menú contextual
        registerForContextMenu(binding.llPrincipal)

        // Configurar la barra de herramientas y asignar un título
        setSupportActionBar(binding.toolbar.miToolbar)
        supportActionBar?.title = "Menús Activity 1"
    }
}