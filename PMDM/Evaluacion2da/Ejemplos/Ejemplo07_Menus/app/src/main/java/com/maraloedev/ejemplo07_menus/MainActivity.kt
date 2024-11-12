package com.maraloed.ejemplo07_menus

import android.content.Intent
import android.os.Bundle
import com.maraloedev.ejemplo07_menus.GestionMenus
import com.maraloedev.ejemplo07_menus.MainActivity2
import com.maraloedev.ejemplo07_menus.databinding.ActivityMainBinding

class MainActivity : GestionMenus() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bPasarActivity.setOnClickListener(){
            var intentSegundo: Intent = Intent(this, MainActivity2::class.java)
            startActivity(intentSegundo)
        }


        registerForContextMenu(binding.linerLayoutPrincipal)

    }


}