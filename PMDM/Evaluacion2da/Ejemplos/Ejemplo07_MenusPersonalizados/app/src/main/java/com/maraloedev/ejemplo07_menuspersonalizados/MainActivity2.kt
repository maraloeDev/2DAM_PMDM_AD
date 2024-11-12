package com.maraloedev.ejemplo07_menuspersonalizados

import android.os.Bundle
import com.maraloedev.ejemplo07_menuspersonalizados.databinding.ActivityMain2Binding

class MainActivity2 : GestionMenus() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        contexto = binding.llFondoActivity2


        registerForContextMenu(binding.llFondoActivity2)


        setSupportActionBar(binding.toolbar.miToolbar)
        supportActionBar?.title = "Menús Activity 2"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}