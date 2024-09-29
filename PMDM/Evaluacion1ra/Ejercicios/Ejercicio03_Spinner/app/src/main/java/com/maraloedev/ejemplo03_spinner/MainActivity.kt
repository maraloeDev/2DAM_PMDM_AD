package com.maraloedev.ejemplo03_spinner

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejemplo03_spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val listaNombres: ArrayList<String> = arrayListOf()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNombres)
        binding.lvListaNombres.adapter = adapter



        binding.bRecuperarName.setOnClickListener {

            val nombreIntroducido: String = binding.etNombre.text.toString()
            listaNombres.add(nombreIntroducido)
            adapter.notifyDataSetChanged()
        }

    }
}