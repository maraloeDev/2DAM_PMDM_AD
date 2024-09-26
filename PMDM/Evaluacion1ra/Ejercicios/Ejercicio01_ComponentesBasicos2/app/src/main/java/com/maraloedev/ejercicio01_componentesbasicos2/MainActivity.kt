package com.maraloedev.ejercicio01_componentesbasicos2

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejercicio01_componentesbasicos2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.etInputName
        val comunidades = binding.spComunidades
        val deportes = listOf(binding.cbTenis, binding.cbFutbol, binding.cbBaloncesto)

        deportes.forEach { deporte ->
            deporte.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    Toast.makeText(this, "El deporte seleccionado es ${buttonView.text}", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "No se ha seleccionado ningún deporte", Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.btnGuardar.setOnClickListener {
            Toast.makeText(this, "El nombre es ${name.text}", Toast.LENGTH_LONG).show()

            // Obtener el RadioButton seleccionado
            val selectedRadioButtonId = binding.rgEstado.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val selectedRadioText = selectedRadioButton.text
                Toast.makeText(this, "Estado seleccionado: $selectedRadioText", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No se ha seleccionado ningún estado", Toast.LENGTH_LONG).show()
            }

            Toast.makeText(this, "La comunidad seleccionada es ${comunidades.selectedItem}", Toast.LENGTH_LONG).show()
        }
    }
}