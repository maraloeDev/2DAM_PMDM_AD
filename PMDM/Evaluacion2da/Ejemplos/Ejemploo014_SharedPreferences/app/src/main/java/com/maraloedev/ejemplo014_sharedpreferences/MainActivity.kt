package com.maraloedev.ejemploo014_sharedpreferences

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maraloedev.ejemploo014_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferencesLectura = getSharedPreferences("preferencias", MODE_PRIVATE)
        val nombre = sharedPreferencesLectura.getString("nombre", "no definido")
        val contrasena = sharedPreferencesLectura.getString("contrasena", "no definido")
        val Usuario = Usuario(nombre.toString(), contrasena.toString())

        binding.bGuardar.setOnClickListener {
            val sharedPreference = getSharedPreferences("preferencias", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("nombre", Usuario.nombre)
            editor.putString("contrasena", Usuario.contrasena)
            editor.apply()
        }
    }
}