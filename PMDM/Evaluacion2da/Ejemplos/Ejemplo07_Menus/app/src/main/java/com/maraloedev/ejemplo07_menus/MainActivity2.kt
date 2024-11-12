package com.maraloedev.ejemplo07_menus

import android.os.Bundle
import com.maraloedev.ejemplo07_menus.databinding.ActivityMain2Binding

class MainActivity2 : GestionMenus() {

    lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.llFondoActivity2)

    }
}