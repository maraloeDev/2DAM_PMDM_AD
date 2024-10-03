package com.maraloedev.ejercicio03_spinner_listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejercicio03_spinner_listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Recupero en la variable dato, lo que a introducido el usuario
         * Creo en la variable listaDatos una lista que almacenar el dato introducido por el usuario
         */
        val dato = binding.etAnadirDato
        val listaDatos: MutableList<String> = mutableListOf()
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_activated_1,
            listaDatos
        )

        /**
         * Añado el adapter al componente lvDatos
         */
        binding.lvDatos.adapter = adapter

        /**
         * Cuando pulso al boton añadir, compruebo si el dato esta vacio,
         *          Si es asi, muestro un mensaje
         *          Si no es asi, entonces se añade a la lista y se vacia el input del usuario
         */
        binding.bAnadir.setOnClickListener {

            if (dato.text.isNullOrBlank()) {
                Toast.makeText(this, "El dato esta vacio", Toast.LENGTH_LONG).show()
            } else {
                listaDatos.add(dato.text.toString())
                adapter.notifyDataSetChanged()
                dato.setText("")
            }
        }

        /**
         * Cuando pulso al boton borrar, compruebo si el dato esta vacio,
         *          Si es asi, muestro un mensaje
         *          Si no es asi, entonceselimino el ultimo de la lista
         */

        binding.bBorrar.setOnClickListener {

            if (dato.text.isNullOrBlank()) {
                Toast.makeText(this, "El dato esta vacio", Toast.LENGTH_LONG).show()
            } else {
                listaDatos.removeAt(listaDatos.size - 1)
                adapter.notifyDataSetChanged()
                dato.setText("")
            }
        }
    }
}