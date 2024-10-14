package com.maraloedev.ejemplo03_constraintlayout

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.maraloedev.ejemplo03_constraintlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var nombreUsuario = binding.tietNombre.text
        var apellido1 = binding.tietApellido1.text
        var apellido2 = binding.tietApellido2.text

        binding.button.setOnClickListener {
            val usuario =
                Usuario(nombreUsuario.toString(), apellido1.toString(), apellido2.toString())
            val mensaje =
                "Los datos del usuario son: ${usuario.nombre}, ${usuario.apellido1}, ${usuario.apellido2}"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()

        }

    }
}