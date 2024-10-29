package com.maraloedev.examenandroid3

import android.os.Bundle
import android.view.MotionEvent
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.examenandroid3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGrabar.isEnabled = false


        binding.tbOnOFF.setOnCheckedChangeListener { compoundButton, isChecked ->
            binding.bGrabar.isEnabled = isChecked
        }

        val listaDatosUser: MutableList<DatosUser> = mutableListOf()

        binding.bGrabar.setOnClickListener {
            val nombre = binding.etNombre.text.toString()
            val edad = binding.etEdad.text.toString()
            val ciudad = binding.spCiudades.selectedItem.toString()

            val newUser = DatosUser(nombre, edad, ciudad)
            listaDatosUser.add(newUser)

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaDatosUser)
            binding.lvDatosUsuario.adapter = adapter
            adapter.notifyDataSetChanged()
        }

        binding.lvDatosUsuario.setOnItemClickListener { adapterView, view, i, l ->
            val nombre = binding.etNombre.text.toString()
            val edad = binding.etEdad.text.toString()
            val ciudad = binding.spCiudades.selectedItem.toString()

            Toast.makeText(this, "NOMBRE $nombre EDAD $edad CIUDAD $ciudad", Toast.LENGTH_LONG)
                .show()
        }
    }
}