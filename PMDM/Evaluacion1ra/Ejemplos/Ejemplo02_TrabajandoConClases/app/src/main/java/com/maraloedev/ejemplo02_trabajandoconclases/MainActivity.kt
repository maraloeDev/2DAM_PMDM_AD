package com.maraloedev.ejemplo02_trabajandoconclases

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo02_trabajandoconclases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pepe = Persona("Pepe", "1234")
        pepe.contrasena = "4321"
        Log.d("Depurando", "Nombre: ${pepe.nombre} \n Contraseña: ${pepe.contrasena}")

        val datos: ArrayList<Persona> = ArrayList()
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, datos)
        binding.lvListaPersonas.adapter = adapter

        binding.bGuardar.setOnClickListener {
            val usuario = Persona(
                binding.tilNombre.text.toString(),
                binding.tilPassword.text.toString(),
                binding.tilEdad.text.toString().toInt()
            )
            Log.d("depurando", usuario.toString())

            val personaVacia = Persona()
            binding.usuario = personaVacia
            adapter.add(usuario)
        }

        binding.lvListaPersonas.setOnItemClickListener { _, _, position, _ ->
            datos.removeAt(position)
            adapter.notifyDataSetChanged()
        }
    }
}