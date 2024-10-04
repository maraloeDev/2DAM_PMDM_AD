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

        val pepe = persona("Pepe", "1234")
        // Actualizar la propiedad contrasena
        pepe.contrasena = "4321"
        Log.d("Depurando", "Nombre: ${pepe.nombre} \n Contraseña: ${pepe.contrasena}")

        binding.usuario.nombre
        val datos: ArrayList<persona> = ArrayList()
        binding.lvListaPersonas.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, datos)

        binding.button.setOnClickListener {
            val usuario = persona(binding.HintName.text.toString(), binding.HintPassword.text.toString(),binding.HintEdad.text.toString().toInt())

            Log.d("depurando", usuario.toString())

var personaVacia:persona = persona()
            binding.usuario = personaVacia
            (binding.lvListaPersonas.adapter as ArrayAdapter<persona>).add(usuario)
        }
    }
}