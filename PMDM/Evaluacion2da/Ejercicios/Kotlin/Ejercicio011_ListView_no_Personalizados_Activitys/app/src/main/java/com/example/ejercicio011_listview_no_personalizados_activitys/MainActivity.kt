package com.example.ejercicio011_listview_no_personalizados_activitys

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio011_listview_no_personalizados_activitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listaProductos:ArrayList<Producto> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, listaProductos)

        binding.bAnadir.setOnClickListener {

            //Recupero los datos
            val nombre = binding.tietNombreDelProducto.text
            val precio = binding.tietPrecioDelProducto.text

            listaProductos.add(Producto(nombre.toString(), precio.toString()))

            binding.lvListaCompra.adapter = adapter
            adapter.notifyDataSetChanged()
        }

        binding.bBorrar.setOnClickListener {
    val nombre = binding.tietNombreDelProducto.text.toString()
    val precio = binding.tietPrecioDelProducto.text.toString()
    val borrarProd = listaProductos.find { it.nombre == nombre }
    if (borrarProd != null) {
        listaProductos.remove(borrarProd)
        adapter.notifyDataSetChanged()
    }
}

        binding.lvListaCompra.setOnItemClickListener { adapterView, view, i, l ->
            binding.tietNombreDelProducto.setText(listaProductos[i].nombre)
            binding.tietPrecioDelProducto.setText(listaProductos[i].precio)
        }

    }
}