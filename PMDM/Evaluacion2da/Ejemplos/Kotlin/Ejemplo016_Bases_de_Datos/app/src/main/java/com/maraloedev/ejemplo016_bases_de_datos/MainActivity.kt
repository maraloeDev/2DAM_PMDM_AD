package com.maraloedev.ejemplo016_bases_de_datos

import android.os.Bundle
import android.util.Log
import android.view.View
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

        // Crea una instancia de la base de datos.
        val basedatos: Conexion_Base_de_datos =
            Room.databaseBuilder(this, Conexion_Base_de_datos::class.java, "bdPersonas")
                .allowMainThreadQueries()
                .build()
        val personaDAO = basedatos.personaDao()

        // Configura el botón para insertar una nueva persona.
        binding.bInsertar.setOnClickListener {
            val persona = Persona(
                binding.tietDireccion.text.toString(),
                binding.tietEdad.text.toString().toInt().toString(),
                binding.tietNombre.text.toString()
            )
            Log.d("Persona", persona.toString())
            personaDAO?.insertar(persona)
        }

        // Configura el botón para recuperar la primera persona.
        binding.bRecuperarPrimero.setOnClickListener {
            val persona = personaDAO?.recuperarUsuario(1)
            binding.persona = persona
        }

        // Configura el botón para listar todas las personas.
        binding.bListar.setOnClickListener {
            val personas = personaDAO?.listar()
            val adaptador = ArrayAdapter<Persona>(this, android.R.layout.simple_list_item_1, personas!!)
            binding.lvPersonas.adapter = adaptador
        }

        // Configura el evento de clic en los elementos de la lista.
        binding.lvPersonas.setOnItemClickListener { adapterView, view, i, l ->
            val persona = (adapterView as ArrayAdapter<Persona>).getItem(i)
            binding.persona = persona
        }

        // Configura el botón para borrar una persona.
        binding.bBorrar.setOnClickListener {
            val persona = Persona(
                binding.tietDireccion.text.toString(),
                binding.tietEdad.text.toString().toInt().toString(),
                binding.tietNombre.text.toString()
            )
            persona.id = binding.tietId.text.toString().toInt().toString()
            personaDAO?.eliminar(persona)
        }

        // Configura el botón para actualizar una persona.
        binding.bActualizar.setOnClickListener(View.OnClickListener {
            val persona = Persona(
                binding.tietDireccion.text.toString(),
                binding.tietEdad.text.toString().toInt().toString(),
                binding.tietNombre.text.toString()
            )
            persona.id = binding.tietId.text.toString().toInt().toString()
            personaDAO?.actualizar(persona)
        })
    }
}