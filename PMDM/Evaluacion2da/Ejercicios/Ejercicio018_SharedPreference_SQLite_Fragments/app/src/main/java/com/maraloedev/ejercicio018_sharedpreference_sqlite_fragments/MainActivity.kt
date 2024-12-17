package com.maraloedev.ejercicio018_sharedpreference_sqlite_fragments

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.ejercicio018_sharedpreference_sqlite_fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creo el xml de datosUsuario
        val sharedPreferencesLectura = getSharedPreferences("datosUsuarioLectura", MODE_PRIVATE)

        //Almaceno en el sharedPreferences los datos de nombre y telefono
        val nombre = sharedPreferencesLectura.getString("nombre", binding.tietNombre.text.toString())
        val telefono = sharedPreferencesLectura.getString("telefono",binding.tietTelefono.text.toString())

        //Una vez almacenado en variables, lo almaceno en un objeto usuario
            val Usuario = Usuario(nombre!!, telefono!!)


        /**
         * Una vez almacenado, cuando hago click en el boton guardar, edito el Shared Preferences
         * para almacenar los datos en datos usuario
         */

        binding.bGuardar.setOnClickListener {

            val sharedPreferences = getSharedPreferences("datosUsuario", MODE_PRIVATE)
            val editor = sharedPreferences.edit()

            editor.putString("nombre", binding.tietNombre.text.toString())
            editor.putString("telefono", binding.tietTelefono.text.toString())
            Snackbar.make(binding.root, "DATOS ALMACENADOS CORRECTAMENTE", Snackbar.LENGTH_LONG).show()
            editor.commit()
        }
    }
}