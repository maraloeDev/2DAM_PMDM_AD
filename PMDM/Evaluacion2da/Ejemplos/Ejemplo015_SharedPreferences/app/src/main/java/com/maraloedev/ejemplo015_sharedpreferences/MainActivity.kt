package com.maraloedev.ejemplo015_sharedpreferences

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.maraloedev.ejemplo015_sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferencesLectura = getSharedPreferences("preferenciasLectura", Context.MODE_PRIVATE)
        val nombre = sharedPreferencesLectura.getString("nombre", "no definido")
        val contrasena = sharedPreferencesLectura.getString("contrasena", "no definido")
        val Usuario = Usuario(nombre!!, contrasena!!)

        binding.bGuardar.setOnClickListener {
            val sharedPreference = getSharedPreferences("preferencias", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("nombre", binding.tietNombre.text.toString())
            editor.putString("contrasena", binding.tietContrasena.text.toString())
            editor.apply()
            Snackbar.make(binding.root,"DATOS ALMACENADOS CORRECTAMENTE", Snackbar.LENGTH_LONG).show()


            //ALMACENAR EN UNA LISTA EL NOMBRE, Y SABER SI EL NOMBRE INTRODUCIDO, ESTA EN LA LISTA O NO

            val listaUsuarios:ArrayList<String> = arrayListOf()


            if (listaUsuarios.contains(sharedPreference.getString("nombre", binding.tietNombre.text.toString()))) {
                Snackbar.make(binding.root,"ESTE NOMBRE YA EXISTE", Snackbar.LENGTH_LONG).show()
            } else {

            listaUsuarios.add(Usuario.nombre)
            }
        }
    }
}