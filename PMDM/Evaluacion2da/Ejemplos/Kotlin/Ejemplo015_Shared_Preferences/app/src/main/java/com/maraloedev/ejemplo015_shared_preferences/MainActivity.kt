package com.maraloedev.ejemplo015_shared_preferences

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejemplo015_shared_preferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recupero las preferencias compartidas en modo privado
        val sharedPrefLectura = getSharedPreferences("preferencias", MODE_PRIVATE)

        // Lee los valores almacenados de nombre y contraseña
        val nombre = sharedPrefLectura.getString("nombre", "no definido")
        val contrasena = sharedPrefLectura.getString("contrasena", "no definido")

        // Asigna los valores leídos al objeto Usuario en el enlace
        binding.usuario = Usuario(nombre!!, contrasena!!)


        binding.bGuardar.setOnClickListener {
            // Recojo los valores ingresados por el usuario
            val nombre = binding.tietNombre.text.toString()
            val contrasena = binding.tietContrasena.text.toString()

            // Crea un nuevo objeto Usuario con los valores ingresados
            val usuario = Usuario(nombre, contrasena)

            // Obtiene las preferencias compartidas en modo privado
            val sharedPreference = getSharedPreferences("preferencias", MODE_PRIVATE)

            // Inicia la edición de las preferencias
            val editor = sharedPreference.edit()
            // Almacena los valores de nombre y contraseña
            editor.putString("nombre", usuario.nombre)
            editor.putString("contrasena", usuario.contrasena)
            // Aplica los cambios de manera sincrónica
            editor.commit()
        }
    }
}