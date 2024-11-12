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
        contexto = binding.llPrincipal


        binding.bPasarActivity.setOnClickListener(){
            var intentSegundo: Intent = Intent(this, MainActivity2::class.java)
            startActivity(intentSegundo)
        }


        registerForContextMenu(binding.llPrincipal)


        setSupportActionBar(binding.toolbar.miToolbar)
        supportActionBar?.title = "Menús Activity 1"


    }


}