package com.maraloedev.ejemplo01_componentesbasicos

import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo01_componentesbasicos.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listaNombres: ArrayList<String> = arrayListOf("Juan", "Pedro")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNombres)
        binding.lvListaNombres.adapter = adapter

        binding.bRecuperarName.setOnClickListener {
            val estadoCivil: String =
                findViewById<RadioButton>(binding.rgEstado.checkedRadioButtonId).text.toString()
            binding.tvMensaje.text =
                "Hola ${binding.etNombre.text} el estado civil es $estadoCivil, y el color favorito: ${binding.spColoresGUI.selectedItem}"

            val nombreIntroducido: String = binding.etNombre.text.toString()
            listaNombres.add(nombreIntroducido)
            adapter.notifyDataSetChanged()
        }

        binding.swActivarDesactivar.setOnCheckedChangeListener { _, isChecked ->
            binding.bRecuperarName.isEnabled = !isChecked
        }

        binding.spColoresCodigo.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: android.view.View?,
                    position: Int,
                    id: Long
                ) {
                    Log.d("depurando", "Seleccionado: ${binding.spColoresGUI.selectedItem}")
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    Log.d("depurando", "Nada seleccionado")
                }
            }

        val datosDesplegable = arrayOf("Rojo", "Verde", "Azul", "Amarillo")
        binding.spColoresCodigo.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, datosDesplegable)
    }
}