package com.maraloedev.ejercicio010_menus_de_aplicaciones

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejercicio010_menus_de_aplicaciones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //Creo la lista de productos para almacenar los preductos
    private val listaProductos = mutableListOf<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creo el ArrayAdapter, para añadir los productos
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaProductos)

        //Cuando le des click al boton de añadir, se añadira el nombre y el precio a la lista
        binding.bAnadir.setOnClickListener {
            //asigna el ArrayAdapter al ListView para que el ListView pueda mostrar los elementos de la lista de productos (listaProductos).
            binding.listView.adapter = adapter

            //Recupero el nombre y el precio del producto
            var nombreProducto = binding.tietNombreDelProducto.text.toString()
            var precioProducto = binding.tietIntroduceUnPrecioParaElProducto.text.toString()

            //Lo almaceno en la listaProductos
            listaProductos.add(Producto(nombreProducto, precioProducto))
            adapter.notifyDataSetChanged()
        }

        //Cuando le des al boton de borrar, eliminara el elemento seleccionado

        binding.bBorrar.setOnClickListener {
            // Recojo el nombre del producto
            val productName = binding.tietNombreDelProducto.text.toString()

            // Almaceno la el primer elemento que contiene el nombre
            val posicion = listaProductos.indexOfFirst { it.nombre == productName }

            //Comparo si la posicion es diferente que -1
            if (posicion != -1) {
                listaProductos.removeAt(posicion)
                adapter.notifyDataSetChanged()
            }
        }
    }
}