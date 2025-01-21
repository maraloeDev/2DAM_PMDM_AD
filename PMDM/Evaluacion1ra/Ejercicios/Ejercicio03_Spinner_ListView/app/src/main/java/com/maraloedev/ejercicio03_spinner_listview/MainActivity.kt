package com.maraloedev.ejercicio03_spinner_listview

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import com.maraloedev.ejercicio03_spinner_listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Recojo los componentes
        val dato_Insertado = binding.etDato
        val boton_Anadir = binding.bAnadir
        val boton_Borrar = binding.bBorrar
        val lvDatos = binding.lvDatos

        val listaDatos = mutableListOf<String>()

        //Creo un adaptador para añadirlo a la lvDatos

        val adapter = ArrayAdapter<String> (this,android.R.layout.simple_list_item_activated_1, listaDatos)

        //Si se da clic al boton de Añadir, se añadira a la lista el dato insertado
        boton_Anadir.setOnClickListener {
            listaDatos.add(dato_Insertado.text.toString())
            lvDatos.adapter = adapter
            adapter.notifyDataSetChanged()
            dato_Insertado.setText("")
        }

        //Si se da clic al boton de Borrar, se eliminara el ultimo dato de la lista
        boton_Borrar.setOnClickListener {
            listaDatos.removeAt(lvDatos.size-1)
            lvDatos.adapter = adapter
            adapter.notifyDataSetChanged()
            dato_Insertado.setText("")
        }

        lvDatos.setOnItemClickListener { _, _, position, _ ->
            listaDatos.removeAt(listaDatos.size-1)
            lvDatos.adapter = adapter
            adapter.notifyDataSetChanged()
            dato_Insertado.setText("")
        }

    }
}