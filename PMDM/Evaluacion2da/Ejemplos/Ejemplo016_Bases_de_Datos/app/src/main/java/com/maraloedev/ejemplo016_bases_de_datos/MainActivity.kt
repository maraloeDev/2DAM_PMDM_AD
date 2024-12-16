package com.maraloedev.ejemplo016_bases_de_datos

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.maraloedev.ejemplo016_bases_de_datos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val basedatos: BD =
            Room.databaseBuilder(this, BD::class.java, "bdPersonas").allowMainThreadQueries()
                .build()
        val personaDAO = basedatos.personaDao()

        binding.bInsertar.setOnClickListener {
            val persona = Persona(
                binding.tietNombre.text.toString(),
                binding.tietEdad.text.toString().toInt(),
                binding.tietDireccion.text.toString()
            )
            Log.d("Persona", persona.toString())
            personaDAO?.insertar(persona)
        }

        binding.bRecuperarPersona.setOnClickListener {
           val id = binding.tietId.text.toString().toInt()
            val persona = personaDAO?.recuperarUsuario(id)
            binding.persona = persona
        }

        binding.bListar.setOnClickListener {
            val persona = personaDAO?.listar()
            val adaptador =
                ArrayAdapter<Persona>(this, android.R.layout.simple_spinner_item, persona!!)

            binding.lvPersonas.adapter = adaptador
        }

        binding.bBorrar.setOnClickListener {
            val id = binding.tietId.text.toString().toInt()
            val persona = personaDAO?.recuperarUsuario(id)
            personaDAO?.eliminar(persona!!)
        }

        binding.bActualizar.setOnClickListener {
            val persona = personaDAO?.recuperarUsuario(binding.tietId.text.toString().toInt())
            persona?.nombre = binding.tietNombre.text.toString()
            persona?.edad = binding.tietEdad.text.toString().toInt()
            persona?.direccion = binding.tietDireccion.text.toString()
            personaDAO?.actualizar(persona!!)
        }

        binding.lvPersonas.setOnItemClickListener { adapterView, view, i, l ->
            val persona = adapterView.getItemAtPosition(i) as Persona
            binding.persona = persona
        }

    }
}