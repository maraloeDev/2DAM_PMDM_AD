package com.maraloedev.ejemplo017_recycled_view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.maraloedev.ejemplo017_recycled_view.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Crear instancias de la clase Persona con datos de ejemplo
        val persona1 = Persona(ContextCompat.getDrawable(this, R.drawable.foto1)!!,"Victor",23,"983 44 22 33")
        val persona2 = Persona(ContextCompat.getDrawable(this, R.drawable.foto2)!!,"Victor2",32,"983 48 55 33")
        val persona3 = Persona(ContextCompat.getDrawable(this, R.drawable.foto3)!!,"Victor3",44, "983 45 66 33")

        // Crear una lista mutable de personas y agregar las instancias creadas
        val listaPersonas = mutableListOf(persona1,persona2,persona3)


        binding.bAnadir.setOnClickListener {
            val persona = Persona(ContextCompat.getDrawable(this, R.drawable.foto1)!!,binding
                .tietNombre.text.toString(),binding.tietEdad.text.toString().toInt(),binding
                    .tietTelefono.text.toString())
            listaPersonas.add(persona)
            // Notificar al adaptador que se ha insertado un nuevo elemento
            binding.rvVistaDatos.adapter?.notifyItemInserted(listaPersonas.size-1)
        }

        // Configurar el RecyclerView con el adaptador y el layout manager
        binding.rvVistaDatos.adapter = AdaptadorPersona(listaPersonas)
        binding.rvVistaDatos.layoutManager = LinearLayoutManager(this)
    }
}